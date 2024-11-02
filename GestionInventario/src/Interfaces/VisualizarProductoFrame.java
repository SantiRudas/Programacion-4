/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Rudas
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import parcial1.Producto;
import parcial1.ProductoDuradero;
import parcial1.ProductoPerecedero;
import parcial1.ProductoRepositorio;

public class VisualizarProductoFrame extends JDialog {
    private JComboBox<Producto> productosComboBox;
    private JTable productosPerecederosTable;
    private JTable productosDuraderosTable;
    private DefaultTableModel perecederosTableModel;
    private DefaultTableModel duraderosTableModel;

    public VisualizarProductoFrame(JFrame parent) {
        super(parent, "Visualizar Producto", true);
        setSize(1200, 600); // Ampliar tamaño de la interfaz
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla y el JTable para productos perecederos
        perecederosTableModel = new DefaultTableModel(new String[] {"Nombre", "Descripción", "Categoría", "Cantidad", "Precio", "Unidad de Medida", "Fecha de Vencimiento"}, 0);
        productosPerecederosTable = new JTable(perecederosTableModel);
        productosPerecederosTable.setFillsViewportHeight(true);

        // Crear el modelo de la tabla y el JTable para productos duraderos
        duraderosTableModel = new DefaultTableModel(new String[] {"Nombre", "Descripción", "Categoría", "Cantidad", "Precio", "Unidad de Medida", "Duración", "Fecha de Fabricación"}, 0);
        productosDuraderosTable = new JTable(duraderosTableModel);
        productosDuraderosTable.setFillsViewportHeight(true);

        // Ajustar el ancho de las columnas
        ajustarColumnas(productosPerecederosTable, false);
        ajustarColumnas(productosDuraderosTable, true);

        // Crear panel para las tablas y etiquetas
        JPanel tablasPanel = new JPanel(new GridLayout(2, 1));
        
        // Panel para productos perecederos
        JPanel perecederosPanel = new JPanel(new BorderLayout());
        perecederosPanel.add(new JLabel("Productos Perecederos"), BorderLayout.NORTH);
        perecederosPanel.add(new JScrollPane(productosPerecederosTable), BorderLayout.CENTER);
        
        // Panel para productos duraderos
        JPanel duraderosPanel = new JPanel(new BorderLayout());
        duraderosPanel.add(new JLabel("Productos Duraderos"), BorderLayout.NORTH);
        duraderosPanel.add(new JScrollPane(productosDuraderosTable), BorderLayout.CENTER);
        
        // Agregar paneles al panel principal
        tablasPanel.add(perecederosPanel);
        tablasPanel.add(duraderosPanel);

        // Crear un panel para el ComboBox y agregarlo a la izquierda
        JPanel comboBoxPanel = new JPanel(new FlowLayout());
        comboBoxPanel.add(new JLabel("Seleccionar Producto:"));
        
        // ComboBox para seleccionar productos
        productosComboBox = new JComboBox<>(ProductoRepositorio.obtenerProductos().toArray(new Producto[0]));
        productosComboBox.setPreferredSize(new Dimension(300, 25));
        comboBoxPanel.add(productosComboBox);

        // Agregar el panel de ComboBox y las tablas al panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(comboBoxPanel, BorderLayout.WEST);
        mainPanel.add(tablasPanel, BorderLayout.CENTER);
        
        // Agregar el panel principal al centro
        add(mainPanel, BorderLayout.CENTER);

        // Mostrar todos los productos inicialmente
        mostrarTodosLosProductos();

        // Acción al seleccionar un producto en el ComboBox
        productosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacionProducto(); // Actualizar al seleccionar un nuevo producto
            }
        });
    }

    private void ajustarColumnas(JTable table, boolean isDuradero) {
        TableColumn column;

        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            switch (i) {
                case 0: // Nombre
                    column.setPreferredWidth(150);
                    break;
                case 1: // Descripción
                    column.setPreferredWidth(250);
                    break;
                case 2: // Categoría
                    column.setPreferredWidth(150);
                    break;
                case 3: // Cantidad
                    column.setPreferredWidth(100);
                    break;
                case 4: // Precio
                    column.setPreferredWidth(100);
                    break;
                case 5: // Unidad de Medida
                    column.setPreferredWidth(100);
                    break;
                case 6: // Fecha de Vencimiento o Duración
                    column.setPreferredWidth(isDuradero ? 120 : 150);
                    break;
                case 7: // Fecha de Fabricación
                    if (isDuradero) {
                        column.setPreferredWidth(150);
                    } else {
                        table.removeColumn(column); // No aplicar para productos perecederos
                    }
                    break;
            }
        }
    }

    private void mostrarTodosLosProductos() {
        // Limpiar las tablas antes de agregar los nuevos productos
        perecederosTableModel.setRowCount(0);
        duraderosTableModel.setRowCount(0);

        List<Producto> productos = ProductoRepositorio.obtenerProductos();
        for (Producto producto : productos) {
            Object[] rowData = new Object[7]; // Cambiar a 7 para productos perecederos
            if (producto instanceof ProductoPerecedero) {
                rowData[0] = producto.getNombre();
                rowData[1] = producto.getDescripcion();
                rowData[2] = producto.getCategoria();
                rowData[3] = producto.getCantidadInicial();
                rowData[4] = producto.getPrecio();
                rowData[5] = producto.getUnidadDeMedida();
                rowData[6] = ((ProductoPerecedero) producto).getFechaDeVencimiento();
                perecederosTableModel.addRow(rowData);
            } else if (producto instanceof ProductoDuradero) {
                rowData = new Object[8]; // Cambiar a 8 para productos duraderos
                rowData[0] = producto.getNombre();
                rowData[1] = producto.getDescripcion();
                rowData[2] = producto.getCategoria();
                rowData[3] = producto.getCantidadInicial();
                rowData[4] = producto.getPrecio();
                rowData[5] = producto.getUnidadDeMedida();
                rowData[6] = ((ProductoDuradero) producto).getDuracionEnMeses();
                rowData[7] = ((ProductoDuradero) producto).getFechaDeFabricacion();
                duraderosTableModel.addRow(rowData);
            }
        }
    }

    private void mostrarInformacionProducto() {
        Producto seleccionado = (Producto) productosComboBox.getSelectedItem();
        if (seleccionado != null) {
            // Mostrar detalles del producto seleccionado en un cuadro de diálogo
            StringBuilder info = new StringBuilder();
            info.append("Nombre: ").append(seleccionado.getNombre()).append("\n");
            info.append("Descripción: ").append(seleccionado.getDescripcion()).append("\n");
            info.append("Categoría: ").append(seleccionado.getCategoria()).append("\n");
            info.append("Cantidad: ").append(seleccionado.getCantidadInicial()).append("\n");
            info.append("Precio: ").append(seleccionado.getPrecio()).append("\n");
            info.append("Unidad de Medida: ").append(seleccionado.getUnidadDeMedida()).append("\n");

            if (seleccionado instanceof ProductoPerecedero) {
                info.append("Fecha de Vencimiento: ").append(((ProductoPerecedero) seleccionado).getFechaDeVencimiento()).append("\n");
            } else if (seleccionado instanceof ProductoDuradero) {
                info.append("Duración en Meses: ").append(((ProductoDuradero) seleccionado).getDuracionEnMeses()).append("\n");
                info.append("Fecha de Fabricación: ").append(((ProductoDuradero) seleccionado).getFechaDeFabricacion()).append("\n");
            }

            JOptionPane.showMessageDialog(this, info.toString(), "Detalles del Producto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

