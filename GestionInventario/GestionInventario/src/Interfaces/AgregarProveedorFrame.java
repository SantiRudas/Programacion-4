package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parcial1.Proveedor;
import parcial1.ProveedorRepositorio;

public class AgregarProveedorFrame extends JDialog {
    private JTextField nombreField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JTextField idField;
    private JButton guardarButton;
    private ProveedorRepositorio proveedorRepositorio;

    public AgregarProveedorFrame(JFrame parent) {
        super(parent, "Agregar Proveedor", true);
        setSize(450, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 10, 100, 25);
        add(nombreLabel);
        nombreField = new JTextField();
        nombreField.setBounds(170, 10, 250, 25);
        add(nombreField);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setBounds(10, 50, 100, 25);
        add(direccionLabel);
        direccionField = new JTextField();
        direccionField.setBounds(170, 50, 250, 25);
        add(direccionField);

        JLabel telefonoLabel = new JLabel("Telefono:");
        telefonoLabel.setBounds(10, 90, 100, 25);
        add(telefonoLabel);
        telefonoField = new JTextField();
        telefonoField.setBounds(170, 90, 250, 25);
        add(telefonoField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 130, 100, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(170, 130, 250, 25);
        add(idField);
        
        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(150, 300, 150, 30);
        add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText().trim();
                    String direccion = direccionField.getText().trim();
                    String telefono = telefonoField.getText().trim();
                    String id = idField.getText().trim();

                    // Validaciones
                    if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || id.isEmpty()) {
                        JOptionPane.showMessageDialog(AgregarProveedorFrame.this,
                                "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!telefono.matches("\\d{8,15}")) { // Validación simple para números telefónicos
                        JOptionPane.showMessageDialog(AgregarProveedorFrame.this,
                                "El teléfono debe contener solo números y tener entre 8 y 15 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Proveedor proveedor = new Proveedor(nombre, direccion, telefono, id);
                    proveedorRepositorio.agregarProveedor(proveedor);
                    JOptionPane.showMessageDialog(AgregarProveedorFrame.this,
                            "Proveedor agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AgregarProveedorFrame.this,
                            "Error al agregar el proveedor: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLocationRelativeTo(parent);
    }
}


