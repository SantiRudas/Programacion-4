/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import parcial1.Producto;
import parcial1.ProductoDuradero;
import parcial1.ProductoPerecedero;
import parcial1.ProductoRepositorio;

public class AgregarProductoFrame extends JDialog {
    private JTextField nombreField, descripcionField, categoriaField, cantidadField, precioField, unidadMedidaField, idProductoField;
    private JTextField fechaVencimientoField, duracionField, fechaFabricacionField;
    private JButton guardarButton;
    private JComboBox<String> tipoProductoComboBox;
    private JLabel formatoFechaLabel;

    public AgregarProductoFrame(JFrame parent) {
        super(parent, "Agregar Producto", true);  // Esto hace que el diálogo sea modal
        setSize(500, 500);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Campos comunes
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 10, 100, 25);
        add(nombreLabel);
        nombreField = new JTextField();
        nombreField.setBounds(170, 10, 250, 25);
        add(nombreField);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setBounds(10, 50, 100, 25);
        add(descripcionLabel);
        descripcionField = new JTextField();
        descripcionField.setBounds(170, 50, 250, 25);
        add(descripcionField);

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setBounds(10, 90, 100, 25);
        add(categoriaLabel);
        categoriaField = new JTextField();
        categoriaField.setBounds(170, 90, 250, 25);
        add(categoriaField);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setBounds(10, 130, 100, 25);
        add(cantidadLabel);
        cantidadField = new JTextField();
        cantidadField.setBounds(170, 130, 250, 25);
        add(cantidadField);

        JLabel precioLabel = new JLabel("Precio:");
        precioLabel.setBounds(10, 170, 100, 25);
        add(precioLabel);
        precioField = new JTextField();
        precioField.setBounds(170, 170, 250, 25);
        add(precioField);

        JLabel unidadMedidaLabel = new JLabel("Unidad de Medida:");
        unidadMedidaLabel.setBounds(10, 210, 150, 25);
        add(unidadMedidaLabel);
        unidadMedidaField = new JTextField();
        unidadMedidaField.setBounds(170, 210, 250, 25);
        add(unidadMedidaField);
        
        JLabel idProductoLabel = new JLabel("ID Producto:");
        idProductoLabel.setBounds(10, 250, 150, 25);
        add(idProductoLabel);
        idProductoField = new JTextField();
        idProductoField.setBounds(170, 250, 250, 25);
        add(idProductoField);

        // Selector de tipo de producto
        JLabel tipoProductoLabel = new JLabel("Tipo de Producto:");
        tipoProductoLabel.setBounds(10, 290, 150, 25);
        add(tipoProductoLabel);
        tipoProductoComboBox = new JComboBox<>(new String[]{"Perecedero", "Duradero"});
        tipoProductoComboBox.setBounds(170, 290, 250, 25);
        add(tipoProductoComboBox);

        // Campos adicionales
        JLabel fechaVencimientoLabel = new JLabel("Fecha de Vencimiento:");
        fechaVencimientoLabel.setBounds(10, 320, 150, 25);
        add(fechaVencimientoLabel);
        fechaVencimientoField = new JTextField();
        fechaVencimientoField.setBounds(170, 320, 250, 25);
        fechaVencimientoField.setVisible(false);
        add(fechaVencimientoField);
        
        
        JLabel duracionLabel = new JLabel("Duracion en Meses:");
        duracionLabel.setBounds(10, 360, 150, 25);
        add(duracionLabel);
        duracionField = new JTextField();
        duracionField.setBounds(170, 360, 250, 25);
        duracionField.setVisible(false);
        add(duracionField);

        JLabel fechaFabricacionLabel = new JLabel("Fecha de Fabricacion:");
        fechaFabricacionLabel.setBounds(10, 390, 150, 25);
        add(fechaFabricacionLabel);
        fechaFabricacionField = new JTextField();
        fechaFabricacionField.setBounds(170, 390, 250, 25);
        fechaFabricacionField.setVisible(false);
        add(fechaFabricacionField);
        
        formatoFechaLabel = new JLabel("(Formato Fechas: YYYY-MM-DD)");
        formatoFechaLabel.setBounds(10, 420, 200, 20);
        add(formatoFechaLabel);
        
                // Botón Guardar
        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(150, 450, 150, 30);
        add(guardarButton);
        

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
                    String idProducto = idProductoField.getText();

                    String tipo = (String) tipoProductoComboBox.getSelectedItem();
                    Producto producto;

                    if ("Perecedero".equals(tipo)) {
                        LocalDate fechaDeVencimiento = LocalDate.parse(fechaVencimientoField.getText());
                        
                        // Validar que la fecha de vencimiento sea futura
                        if (fechaDeVencimiento.isBefore(LocalDate.now())) {
                            JOptionPane.showMessageDialog(AgregarProductoFrame.this, "La fecha de vencimiento debe ser una fecha futura.", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
                            return; // Salir del método si la fecha es incorrecta
                        }
                        
                        producto = new ProductoPerecedero(nombre, descripcion, categoria, cantidad, precio, unidadDeMedida, idProducto, fechaDeVencimiento);
                    } else {
                        int duracionEnMeses = Integer.parseInt(duracionField.getText());
                        LocalDate fechaDeFabricacion = LocalDate.parse(fechaFabricacionField.getText());
                        
                        if (fechaDeFabricacion.isAfter(LocalDate.now())) {
                            JOptionPane.showMessageDialog(AgregarProductoFrame.this, "La fecha de fabricación no puede ser futura.", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
                            return; // Salir del método si la fecha es incorrecta
                        }
                        
                        producto = new ProductoDuradero(nombre, descripcion, categoria, cantidad, precio, unidadDeMedida, idProducto, duracionEnMeses, fechaDeFabricacion);
                        
                        
                    }

                    ProductoRepositorio.agregarProducto(producto);  // Agrega el producto
                    JOptionPane.showMessageDialog(AgregarProductoFrame.this, "Producto agregado exitosamente.");
                    dispose();
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(AgregarProductoFrame.this, "Formato de fecha incorrecto. Use yyyy-MM-dd.", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AgregarProductoFrame.this, "Formato numérico incorrecto en cantidad o precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AgregarProductoFrame.this, "Error: " + ex.getMessage());
                }
            }
        });
    }
}




