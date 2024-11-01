/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Clase AgregarProductoFrame.java

// Clase AgregarProductoPanel.java
// Clase AgregarProductoFrame.java
package parcial1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AgregarProductoFrame extends JDialog {
    private JTextField nombreField, descripcionField, categoriaField, cantidadField, precioField, unidadMedidaField;
    private JTextField fechaVencimientoField, duracionField, fechaFabricacionField;
    private JButton guardarButton;
    private JComboBox<String> tipoProductoComboBox;

    public AgregarProductoFrame(JFrame parent) {
        super(parent, "Agregar Producto", true);  // Esto hace que el diálogo sea modal
        setSize(400, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Campos comunes
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 10, 100, 25);
        add(nombreLabel);
        nombreField = new JTextField();
        nombreField.setBounds(150, 10, 200, 25);
        add(nombreField);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setBounds(10, 40, 100, 25);
        add(descripcionLabel);
        descripcionField = new JTextField();
        descripcionField.setBounds(150, 40, 200, 25);
        add(descripcionField);

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setBounds(10, 70, 100, 25);
        add(categoriaLabel);
        categoriaField = new JTextField();
        categoriaField.setBounds(150, 70, 200, 25);
        add(categoriaField);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setBounds(10, 100, 100, 25);
        add(cantidadLabel);
        cantidadField = new JTextField();
        cantidadField.setBounds(150, 100, 200, 25);
        add(cantidadField);

        JLabel precioLabel = new JLabel("Precio:");
        precioLabel.setBounds(10, 130, 100, 25);
        add(precioLabel);
        precioField = new JTextField();
        precioField.setBounds(150, 130, 200, 25);
        add(precioField);

        JLabel unidadMedidaLabel = new JLabel("Unidad de Medida:");
        unidadMedidaLabel.setBounds(10, 160, 120, 25);
        add(unidadMedidaLabel);
        unidadMedidaField = new JTextField();
        unidadMedidaField.setBounds(150, 160, 200, 25);
        add(unidadMedidaField);

        // Selector de tipo de producto
        JLabel tipoProductoLabel = new JLabel("Tipo de Producto:");
        tipoProductoLabel.setBounds(10, 190, 120, 25);
        add(tipoProductoLabel);
        tipoProductoComboBox = new JComboBox<>(new String[]{"Perecedero", "Duradero"});
        tipoProductoComboBox.setBounds(150, 190, 200, 25);
        add(tipoProductoComboBox);

        // Campos adicionales
        JLabel fechaVencimientoLabel = new JLabel("Fecha de Vencimiento:");
        fechaVencimientoLabel.setBounds(10, 220, 180, 25);
        add(fechaVencimientoLabel);
        fechaVencimientoField = new JTextField();
        fechaVencimientoField.setBounds(150, 220, 200, 25);
        fechaVencimientoField.setVisible(false);
        add(fechaVencimientoField);
        
        JLabel duracionLabel = new JLabel("Duracion en Meses:");
        duracionLabel.setBounds(10, 250, 180, 25);
        add(duracionLabel);
        duracionField = new JTextField();
        duracionField.setBounds(150, 250, 200, 25);
        duracionField.setVisible(false);
        add(duracionField);

        JLabel fechaFabricacionLabel = new JLabel("Fecha de Fabricacion:");
        fechaFabricacionLabel.setBounds(10, 280, 180, 25);
        add(fechaFabricacionLabel);
        fechaFabricacionField = new JTextField();
        fechaFabricacionField.setBounds(150, 280, 200, 25);
        fechaFabricacionField.setVisible(false);
        add(fechaFabricacionField);

        // Mostrar campos correspondientes al tipo seleccionado
        tipoProductoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) tipoProductoComboBox.getSelectedItem();
                fechaVencimientoField.setVisible("Perecedero".equals(tipo));
                duracionField.setVisible("Duradero".equals(tipo));
                fechaFabricacionField.setVisible("Duradero".equals(tipo));
                revalidate();
                repaint();
            }
        });

        // Botón Guardar
        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(120, 320, 120, 30);
        add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    String descripcion = descripcionField.getText();
                    String categoria = categoriaField.getText();
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    int precio = Integer.parseInt(precioField.getText());
                    String unidadDeMedida = unidadMedidaField.getText();

                    String tipo = (String) tipoProductoComboBox.getSelectedItem();
                    Producto producto;

                    if ("Perecedero".equals(tipo)) {
                        LocalDate fechaDeVencimiento = LocalDate.parse(fechaVencimientoField.getText());
                        producto = new ProductoPerecedero(nombre, descripcion, categoria, cantidad, precio, unidadDeMedida, fechaDeVencimiento);
                    } else {
                        int duracionEnMeses = Integer.parseInt(duracionField.getText());
                        LocalDate fechaDeFabricacion = LocalDate.parse(fechaFabricacionField.getText());
                        producto = new ProductoDuradero(nombre, descripcion, categoria, cantidad, precio, unidadDeMedida, duracionEnMeses, fechaDeFabricacion);
                    }

                    ProductoRepositorio.agregarProducto(producto);  // Agrega el producto
                    JOptionPane.showMessageDialog(AgregarProductoFrame.this, "Producto agregado exitosamente.");
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AgregarProductoFrame.this, "Error: " + ex.getMessage());
                }
            }
        });
    }
}




