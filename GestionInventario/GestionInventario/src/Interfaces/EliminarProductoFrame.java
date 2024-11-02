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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parcial1.Producto;
import parcial1.ProductoDuradero;
import parcial1.ProductoPerecedero;
import parcial1.ProductoRepositorio;

public class EliminarProductoFrame extends JDialog {
    private JComboBox<Producto> productosComboBox;
    private JTextField nombreField, descripcionField, categoriaField, cantidadField, precioField, unidadMedidaField;
    private JTextField fechaVencimientoField, duracionField, fechaFabricacionField;
    private JButton eliminarButton;

    public EliminarProductoFrame(JFrame parent) {
        super(parent, "Eliminar Producto", true);
        setSize(400, 450);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);

        // ComboBox para seleccionar productos
        JLabel seleccionarLabel = new JLabel("Seleccionar Producto:");
        seleccionarLabel.setBounds(10, 10, 150, 25);
        add(seleccionarLabel);

        productosComboBox = new JComboBox<>(ProductoRepositorio.obtenerProductos().toArray(new Producto[0]));
        productosComboBox.setBounds(150, 10, 200, 25);
        add(productosComboBox);

        // Campos para mostrar detalles del producto
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 40, 100, 25);
        add(nombreLabel);
        nombreField = new JTextField();
        nombreField.setBounds(150, 40, 200, 25);
        nombreField.setEditable(false); // Solo lectura
        add(nombreField);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setBounds(10, 70, 100, 25);
        add(descripcionLabel);
        descripcionField = new JTextField();
        descripcionField.setBounds(150, 70, 200, 25);
        descripcionField.setEditable(false);
        add(descripcionField);

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setBounds(10, 100, 100, 25);
        add(categoriaLabel);
        categoriaField = new JTextField();
        categoriaField.setBounds(150, 100, 200, 25);
        categoriaField.setEditable(false);
        add(categoriaField);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setBounds(10, 130, 100, 25);
        add(cantidadLabel);
        cantidadField = new JTextField();
        cantidadField.setBounds(150, 130, 200, 25);
        cantidadField.setEditable(false);
        add(cantidadField);

        JLabel precioLabel = new JLabel("Precio:");
        precioLabel.setBounds(10, 160, 100, 25);
        add(precioLabel);
        precioField = new JTextField();
        precioField.setBounds(150, 160, 200, 25);
        precioField.setEditable(false);
        add(precioField);

        JLabel unidadMedidaLabel = new JLabel("Unidad de Medida:");
        unidadMedidaLabel.setBounds(10, 190, 120, 25);
        add(unidadMedidaLabel);
        unidadMedidaField = new JTextField();
        unidadMedidaField.setBounds(150, 190, 200, 25);
        unidadMedidaField.setEditable(false);
        add(unidadMedidaField);
        
        // Campos para Producto Perecedero
        JLabel fechaVencimientoLabel = new JLabel("Fecha de Vencimiento:");
        fechaVencimientoLabel.setBounds(10, 220, 150, 25);
        add(fechaVencimientoLabel);
        fechaVencimientoField = new JTextField();
        fechaVencimientoField.setBounds(150, 220, 200, 25);
        fechaVencimientoField.setEditable(false);
        add(fechaVencimientoField);

        // Campos para Producto Duradero
        JLabel duracionLabel = new JLabel("Duración en Meses:");
        duracionLabel.setBounds(10, 250, 150, 25);
        add(duracionLabel);
        duracionField = new JTextField();
        duracionField.setBounds(150, 250, 200, 25);
        duracionField.setEditable(false);
        add(duracionField);

        JLabel fechaFabricacionLabel = new JLabel("Fecha de Fabricación:");
        fechaFabricacionLabel.setBounds(10, 280, 150, 25);
        add(fechaFabricacionLabel);
        fechaFabricacionField = new JTextField();
        fechaFabricacionField.setBounds(150, 280, 200, 25);
        fechaFabricacionField.setEditable(false);
        add(fechaFabricacionField);

        // Etiqueta para el formato de fechas
        JLabel formatoFechaLabel = new JLabel("Formato Fechas: YYYY-MM-DD");
        formatoFechaLabel.setBounds(10, 310, 200, 25);
        add(formatoFechaLabel);

        // Botón Eliminar
        eliminarButton = new JButton("Eliminar Producto");
        eliminarButton.setBounds(120, 340, 150, 30);
        add(eliminarButton);

        // Acción al seleccionar un producto
        productosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto seleccionado = (Producto) productosComboBox.getSelectedItem();
                if (seleccionado != null) {
                    nombreField.setText(seleccionado.getNombre());
                    descripcionField.setText(seleccionado.getDescripcion());
                    categoriaField.setText(seleccionado.getCategoria());
                    cantidadField.setText(String.valueOf(seleccionado.getCantidadInicial()));
                    precioField.setText(String.valueOf(seleccionado.getPrecio()));
                    unidadMedidaField.setText(seleccionado.getUnidadDeMedida());
                    
                                        // Limpiar los campos de fecha y duración
                    fechaVencimientoField.setText("");
                    duracionField.setText("");
                    fechaFabricacionField.setText("");
                    
                    // Mostrar/ocultar campos según el tipo de producto y cargar información
                    if (seleccionado instanceof ProductoPerecedero) {
                    // Cargar información específica del producto perecedero
                        fechaVencimientoField.setText(((ProductoPerecedero) seleccionado).getFechaDeVencimiento().toString());
                
                    // Mostrar el campo de fecha de vencimiento y ocultar los demás
                        fechaVencimientoField.setVisible(true);
                        duracionField.setVisible(false);
                        fechaFabricacionField.setVisible(false);
                    } else if (seleccionado instanceof ProductoDuradero) {
                    // Cargar información específica del producto duradero
                        duracionField.setText(String.valueOf(((ProductoDuradero) seleccionado).getDuracionEnMeses()));
                        fechaFabricacionField.setText(((ProductoDuradero) seleccionado).getFechaDeFabricacion().toString());

                    // Mostrar el campo de fecha de fabricación y duración, y ocultar el de vencimiento
                        duracionField.setVisible(true);
                        fechaFabricacionField.setVisible(true);
                        fechaVencimientoField.setVisible(false);
                    }                   
                }
            }
        });

        // Acción al presionar el botón Eliminar
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmacionEliminarProducto();
            }
        });
    }

    private void confirmacionEliminarProducto() {
        Producto productoSeleccionado = (Producto) productosComboBox.getSelectedItem();
        if (productoSeleccionado != null) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que deseas eliminar el producto: " + productoSeleccionado.getNombre() + "?",
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                ProductoRepositorio.eliminarProducto(productoSeleccionado);
                JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente.");
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún producto para eliminar.");
        }
    }
}

