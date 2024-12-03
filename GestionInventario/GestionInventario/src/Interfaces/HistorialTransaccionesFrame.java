/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.File;
import parcial1.Producto;
import parcial1.ProductoRepositorio;
import parcial1.TransaccionInventario;
import parcial1.TransaccionRepositorio;

public class HistorialTransaccionesFrame extends JDialog {
    private JTable tablaTransacciones;
    private JLabel saldoActualLabel;
    private JLabel costoUnitarioLabel;
    private JLabel costoTotalLabel;
    private JComboBox<Producto> productoComboBox;

    public HistorialTransaccionesFrame(JFrame parent) {
        super(parent, "Historial de Transacciones", true);
        setSize(800, 600);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior: Filtro por producto
        JPanel panelFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFiltro.add(new JLabel("Seleccionar Producto:"));

        // ComboBox con lista de productos
        productoComboBox = new JComboBox<>(ProductoRepositorio.obtenerProductos().toArray(new Producto[0]));
        productoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarTablaTransacciones();
                calcularInformacionAdicional();
            }
        });
        panelFiltro.add(productoComboBox);
        add(panelFiltro, BorderLayout.NORTH);

        // Panel central: Tabla de transacciones
        JPanel panelTabla = new JPanel(new BorderLayout());
        tablaTransacciones = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaTransacciones);
        panelTabla.add(scrollPane, BorderLayout.CENTER);
        add(panelTabla, BorderLayout.CENTER);

        // Cargar los datos en la tabla
        cargarTablaTransacciones();

        // Panel inferior: Información adicional
        JPanel panelInfo = new JPanel(new GridLayout(3, 2, 10, 10));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Saldo actual
        panelInfo.add(new JLabel("Saldo Actual:"));
        saldoActualLabel = new JLabel("-");
        panelInfo.add(saldoActualLabel);

        // Costo unitario
        panelInfo.add(new JLabel("Costo Unitario:"));
        costoUnitarioLabel = new JLabel("-");
        panelInfo.add(costoUnitarioLabel);

        // Costo total
        panelInfo.add(new JLabel("Costo Total:"));
        costoTotalLabel = new JLabel("-");
        panelInfo.add(costoTotalLabel);

        add(panelInfo, BorderLayout.SOUTH);

        // Calcular y mostrar la información adicional
        calcularInformacionAdicional();
        
        JButton exportButton = new JButton("Exportar a CSV");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportarA_CSV();
            }
        });
        panelFiltro.add(exportButton);

        setLocationRelativeTo(parent);
    }

    private void cargarTablaTransacciones() {
        // Definir columnas de la tabla
        String[] columnas = {"Fecha", "Tipo Movimiento", "Cantidad", "Valor Unitario", "Valor Total", "Motivo", "Producto"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        // Obtener las transacciones desde el repositorio
        Producto productoSeleccionado = (Producto) productoComboBox.getSelectedItem();
        if (productoSeleccionado == null) {
            tablaTransacciones.setModel(modeloTabla); // Si no hay producto, tabla vacía
            return;
        }
        List<TransaccionInventario> transacciones = TransaccionRepositorio.obtenerTransacciones().stream()
                    .filter(t -> t.getProducto().getIdProducto().equals(productoSeleccionado.getIdProducto()))
                    .collect(Collectors.toList());

        for (TransaccionInventario transaccion : transacciones) {
            Object[] fila = {
                transaccion.getFecha(),
                transaccion.getTipo().toString(),
                transaccion.getCantidad(),
                transaccion.getProducto().getPrecio(),
                transaccion.getCantidad() * transaccion.getProducto().getPrecio(), // Valor Total
                transaccion.getRazon(),
                transaccion.getProducto().getNombre()
            };
            modeloTabla.addRow(fila);
        }

        // Asignar el modelo a la tabla
        tablaTransacciones.setModel(modeloTabla);
    }

    private void calcularInformacionAdicional() {
        saldoActualLabel.setText("-");
        costoUnitarioLabel.setText("-");
        costoTotalLabel.setText("-");

    // Obtener el producto seleccionado
        Producto productoSeleccionado = (Producto) productoComboBox.getSelectedItem();
        if (productoSeleccionado == null) return;

    // Filtrar transacciones para el producto seleccionado
        List<TransaccionInventario> transacciones = TransaccionRepositorio.obtenerTransacciones().stream()
            .filter(t -> t.getProducto().getIdProducto().equals(productoSeleccionado.getIdProducto()))
            .collect(Collectors.toList());

        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones para el producto seleccionado: " + productoSeleccionado.getIdProducto());
            return;
        }
        
        // Calcular saldo actual, costo unitario promedio y costo total
        int saldoActual = 0;
        double costoUnitario = 0;
        int cantidadAcumulada = 0;

        for (TransaccionInventario transaccion : transacciones) {
            if (transaccion.getTipo() == TransaccionInventario.TipoTransaccion.AGREGAR) {
                saldoActual += transaccion.getCantidad();
                costoUnitario += transaccion.getCantidad() * transaccion.getProducto().getPrecio();
                cantidadAcumulada += transaccion.getCantidad();
            } else if (transaccion.getTipo() == TransaccionInventario.TipoTransaccion.DISMINUIR) {
                saldoActual -= transaccion.getCantidad();
            }
        }

    // Calcular el costo unitario promedio
        double costoUnitarioPromedio = cantidadAcumulada > 0 ? (costoUnitario / cantidadAcumulada) : 0.0;

    // Calcular el costo total
        double costoTotal = saldoActual * costoUnitarioPromedio;

    // Mostrar los valores en las etiquetas
        saldoActualLabel.setText(String.valueOf(saldoActual));
        costoUnitarioLabel.setText(String.format("%.2f", costoUnitarioPromedio));
        costoTotalLabel.setText(String.format("%.2f", costoTotal));
    }
    
    private void exportarA_CSV() {
        Producto productoSeleccionado = (Producto) productoComboBox.getSelectedItem();
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto primero.");
            return;
        }

        try {
        // Crear un FileChooser para seleccionar la ubicación del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar como CSV");
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String archivoDestino = fileChooser.getSelectedFile().getAbsolutePath();
                if (!archivoDestino.endsWith(".csv")) {
                    archivoDestino += ".csv";
                }

            // Crear el archivo CSV con OutputStreamWriter y FileWriter para codificación correcta
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoDestino), "UTF-8"))) {
                // Escribir encabezados de las columnas en la primera línea
                    writer.append("Fecha, Tipo Movimiento, Cantidad, Valor Unitario, Valor Total, Motivo, Producto");
                    writer.newLine();  // Asegura que la primera línea sea de encabezados

                // Obtener las transacciones para el producto seleccionado
                    List<TransaccionInventario> transacciones = TransaccionRepositorio.obtenerTransacciones().stream()
                        .filter(t -> t.getProducto().getIdProducto().equals(productoSeleccionado.getIdProducto()))
                        .collect(Collectors.toList());

                // Escribir las filas, con cada valor en su propia columna
                    for (TransaccionInventario transaccion : transacciones) {
                        writer.append(escaparCSV(transaccion.getFecha().toString()))       // Fecha
                            .append(", ")
                            .append(escaparCSV(transaccion.getTipo().toString()))        // Tipo Movimiento
                            .append(", ")
                            .append(String.valueOf(transaccion.getCantidad()))           // Cantidad
                            .append(", ")
                            .append(String.valueOf(transaccion.getProducto().getPrecio())) // Valor Unitario
                            .append(", ")
                            .append(String.valueOf(transaccion.getCantidad() * transaccion.getProducto().getPrecio())) // Valor Total
                            .append(", ")
                            .append(escaparCSV(transaccion.getRazon()))                 // Motivo
                            .append(", ")
                            .append(escaparCSV(transaccion.getProducto().getNombre()))  // Producto
                            .write("\n");  // Asegura que cada transacción esté en una nueva línea
                    }

                // Mensaje de éxito
                    JOptionPane.showMessageDialog(this, "El historial ha sido exportado exitosamente.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el archivo.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al exportar el archivo: " + e.getMessage());
        }
    }

    private String escaparCSV(String valor) {
    // Si el valor contiene comas o saltos de línea, lo rodeamos con comillas dobles
        if (valor.contains(",") || valor.contains("\n") || valor.contains("\"")) {
            valor = "\"" + valor.replace("\"", "\"\"") + "\"";
        }
        return valor;
    }

}


