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
/**
 *
 * @author Rudas
 */
public class EliminarProveedorFrame extends JDialog {
    private JComboBox<Proveedor> proveedorComboBox;
    private JTextField nombreField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JTextField idField;
    private JButton eliminarButton;

    public EliminarProveedorFrame(JFrame parent) {
        super(parent, "Eliminar Proveedor", true);
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
        nombreField.setEditable(false);
        add(nombreField);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setBounds(10, 70, 100, 25);
        add(direccionLabel);
        direccionField = new JTextField();
        direccionField.setBounds(150, 70, 200, 25);
        direccionField.setEditable(false);
        add(direccionField);

        JLabel telefonoLabel = new JLabel("Telefono:");
        telefonoLabel.setBounds(10, 100, 100, 25);
        add(telefonoLabel);
        telefonoField = new JTextField();
        telefonoField.setBounds(150, 100, 200, 25);
        telefonoField.setEditable(false);
        add(telefonoField);
        
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 130, 100, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(150, 130, 200, 25);
        idField.setEditable(false);
        add(idField);
               
        eliminarButton = new JButton("Eliminar Proveedor");
        eliminarButton.setBounds(120, 300, 150, 30);
        add(eliminarButton);
        
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
        
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmacionEliminarProveedor();
            }
        });
    }
    
    private void confirmacionEliminarProveedor() {
        Proveedor Seleccionado = (Proveedor) proveedorComboBox.getSelectedItem();
        if (Seleccionado != null) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que deseas eliminar el proveedor: " + Seleccionado.getNombre() + "?",
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                ProveedorRepositorio.eliminarProveedor(Seleccionado);
                JOptionPane.showMessageDialog(this, "Proveedor eliminado exitosamente.");
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún proveedor para eliminar.");
        }
    }
}

    
