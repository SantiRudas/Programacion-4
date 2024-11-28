/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parcial1.Proveedor;
import parcial1.ProveedorRepositorio;

public class ModificarProveedorFrame extends JDialog {
    private JComboBox<Proveedor> proveedorComboBox;
    private JTextField nombreField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JTextField idField;
    private JButton guardarButton;

    public ModificarProveedorFrame(JFrame parent) {
        super(parent, "Modificar Proveedor", true);
        setSize(400, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        JLabel seleccionarLabel = new JLabel("Seleccionar Proveedor:");
        seleccionarLabel.setBounds(10, 10, 150, 25);
        add(seleccionarLabel);
        
        proveedorComboBox = new JComboBox<>(ProveedorRepositorio.obtenerProveedores().toArray(new Proveedor[0]));
        proveedorComboBox.setBounds(150, 10, 200, 25);
        add(proveedorComboBox);

        // Campos comunes
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 40, 100, 25);
        add(nombreLabel);
        nombreField = new JTextField();
        nombreField.setBounds(150, 40, 200, 25);
        add(nombreField);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setBounds(10, 70, 100, 25);
        add(direccionLabel);
        direccionField = new JTextField();
        direccionField.setBounds(150, 70, 200, 25);
        add(direccionField);

        JLabel telefonoLabel = new JLabel("Telefono:");
        telefonoLabel.setBounds(10, 100, 100, 25);
        add(telefonoLabel);
        telefonoField = new JTextField();
        telefonoField.setBounds(150, 100, 200, 25);
        add(telefonoField);
        
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 130, 100, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(150, 130, 200, 25);
        add(idField);
               
        guardarButton = new JButton("Guardar Cambios");
        guardarButton.setBounds(120, 300, 150, 30);
        add(guardarButton);

        // Listener para cargar los datos del proveedor seleccionado
        proveedorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proveedor Seleccionado = (Proveedor) proveedorComboBox.getSelectedItem();
                if (Seleccionado != null) {
                    nombreField.setText(Seleccionado.getNombre());
                    direccionField.setText(Seleccionado.getDireccion());
                    telefonoField.setText(Seleccionado.getTelefono());
                    idField.setText(Seleccionado.getId());
                }
            }
        });
               
        // Listener para guardar los cambios
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCambiosProveedor();
            }
        });
    }
        
    private void guardarCambiosProveedor() {
        Proveedor proveedorSeleccionado = (Proveedor) proveedorComboBox.getSelectedItem();
        if (proveedorSeleccionado == null) return;

            // Actualiza los campos comunes de los productos
            proveedorSeleccionado.setNombre(nombreField.getText());
            proveedorSeleccionado.setDireccion(direccionField.getText());
            proveedorSeleccionado.setTelefono(telefonoField.getText());
            proveedorSeleccionado.setId(idField.getText());
                
            ProveedorRepositorio.actualizarProveedor(proveedorSeleccionado);
            JOptionPane.showMessageDialog(this, "Proveedor actualizado exitosamente.");
            
            // Cerrar la ventana después de guardar
            dispose();
    }
}

    

