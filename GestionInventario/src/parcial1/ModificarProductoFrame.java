/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarProductoFrame extends JDialog {
    private JComboBox<Producto> productosComboBox;
    private JTextField nombreField, descripcionField, categoriaField, cantidadField, precioField, unidadMedidaField;
    private JTextField fechaVencimientoField, duracionField, fechaFabricacionField;
    private JButton guardarButton;

    public ModificarProductoFrame(JFrame parent) {
        super(parent, "Modificar Producto", true);
        setSize(400, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);

        // ComboBox para seleccionar productos
        JLabel seleccionarLabel = new JLabel("Seleccionar Producto:");
        seleccionarLabel.setBounds(10, 10, 150, 25);
        add(seleccionarLabel);

        productosComboBox = new JComboBox<>(ProductoRepositorio.obtenerProductos().toArray(new Producto[0]));
        productosComboBox.setBounds(150, 10, 200, 25);
        add(productosComboBox);

        // Campos comunes
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 40, 100, 25);
        add(nombreLabel);
        nombreField = new JTextField();
        nombreField.setBounds(150, 40, 200, 25);
        add(nombreField);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setBounds(10, 70, 100, 25);
        add(descripcionLabel);
        descripcionField = new JTextField();
        descripcionField.setBounds(150, 70, 200, 25);
        add(descripcionField);

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setBounds(10, 100, 100, 25);
        add(categoriaLabel);
        categoriaField = new JTextField();
        categoriaField.setBounds(150, 100, 200, 25);
        add(categoriaField);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setBounds(10, 130, 100, 25);
        add(cantidadLabel);
        cantidadField = new JTextField();
        cantidadField.setBounds(150, 130, 200, 25);
        add(cantidadField);

        JLabel precioLabel = new JLabel("Precio:");
        precioLabel.setBounds(10, 160, 100, 25);
        add(precioLabel);
        precioField = new JTextField();
        precioField.setBounds(150, 160, 200, 25);
        add(precioField);

        JLabel unidadMedidaLabel = new JLabel("Unidad de Medida:");
        unidadMedidaLabel.setBounds(10, 190, 120, 25);
        add(unidadMedidaLabel);
        unidadMedidaField = new JTextField();
        unidadMedidaField.setBounds(150, 190, 200, 25);
        add(unidadMedidaField);

        // Campos adicionales (fecha de vencimiento, duración, etc.)
        JLabel fechaVencimientoLabel = new JLabel("Fecha de Vencimiento:");
        fechaVencimientoLabel.setBounds(10, 220, 150, 25);
        add(fechaVencimientoLabel);
        fechaVencimientoField = new JTextField();
        fechaVencimientoField.setBounds(150, 220, 200, 25);
        add(fechaVencimientoField);

        JLabel fechaFabricacionLabel = new JLabel("Fecha de Fabricación:");
        fechaFabricacionLabel.setBounds(10, 250, 150, 25);
        add(fechaFabricacionLabel);
        fechaFabricacionField = new JTextField();
        fechaFabricacionField.setBounds(150, 250, 200, 25);
        add(fechaFabricacionField);

        JLabel duracionLabel = new JLabel("Duración en Meses:");
        duracionLabel.setBounds(10, 280, 150, 25);
        add(duracionLabel);
        duracionField = new JTextField();
        duracionField.setBounds(150, 280, 200, 25);
        add(duracionField);

        // Botón Guardar
        guardarButton = new JButton("Guardar Cambios");
        guardarButton.setBounds(120, 320, 150, 30);
        add(guardarButton);

        // Acción al seleccionar un producto
        productosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto seleccionado = (Producto) productosComboBox.getSelectedItem();
                if (seleccionado != null) {
            // Llenar los campos con la información del producto seleccionado
                    nombreField.setText(seleccionado.getNombre());
                    descripcionField.setText(seleccionado.getDescripcion());
                    categoriaField.setText(seleccionado.getCategoria());
                    cantidadField.setText(String.valueOf(seleccionado.getCantidadInicial()));
                    precioField.setText(String.valueOf(seleccionado.getPrecio()));
                    unidadMedidaField.setText(seleccionado.getUnidadDeMedida());

            // Mostrar/ocultar campos según el tipo de producto
                    if (seleccionado instanceof ProductoPerecedero) {
                        fechaVencimientoField.setText(((ProductoPerecedero) seleccionado).getFechaDeVencimiento().toString());
                        fechaFabricacionField.setVisible(false);
                        duracionField.setVisible(false);
                        fechaVencimientoField.setVisible(true); // Asegúrate de que este campo esté visible
                    } 
                    else if (seleccionado instanceof ProductoDuradero) {
                        fechaFabricacionField.setText(((ProductoDuradero) seleccionado).getFechaDeFabricacion().toString());
                        duracionField.setText(String.valueOf(((ProductoDuradero) seleccionado).getDuracionEnMeses()));
                        fechaVencimientoField.setVisible(false); // Oculta el campo de fecha de vencimiento
                        fechaFabricacionField.setVisible(true); // Asegúrate de que este campo esté visible
                        duracionField.setVisible(true); // Asegúrate de que este campo esté visible
                    }   
                }
            }
        });


        // Guardar cambios
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para guardar los cambios en el producto seleccionado.
                // Actualiza los atributos del producto con los nuevos valores de los campos.
            }
        });
    }
}


