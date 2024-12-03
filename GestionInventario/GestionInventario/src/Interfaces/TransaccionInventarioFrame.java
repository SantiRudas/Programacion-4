/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

import parcial1.Producto;
import parcial1.ProductoRepositorio;
import parcial1.TransaccionInventario;
import parcial1.TransaccionRepositorio;

/**
 *
 * @author Rudas
 */
public class TransaccionInventarioFrame extends JDialog {
    public TransaccionInventarioFrame(JFrame parent, Producto producto) {
        super(parent, "Realizar Transacción", true);
        
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JLabel productoLabel = new JLabel("Producto: " + producto.getNombre());
        add(productoLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel cantidadLabel = new JLabel("Cantidad:");
        JTextField cantidadField = new JTextField();
        
        JLabel razonLabel = new JLabel("Razón:");
        JTextField razonField = new JTextField();
        
        JComboBox<TransaccionInventario.TipoTransaccion> tipoComboBox = new JComboBox<>(TransaccionInventario.TipoTransaccion.values());
        
        panel.add(cantidadLabel);
        panel.add(cantidadField);
        panel.add(razonLabel);
        panel.add(razonField);
        panel.add(new JLabel("Tipo de transacción:"));
        panel.add(tipoComboBox);

        add(panel, BorderLayout.CENTER);

        JButton realizarButton = new JButton("Realizar Transacción");
        realizarButton.addActionListener(e -> {
            try {
                if (cantidadField.getText().isEmpty() || razonField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                    return;
                }
                
                int cantidad = Integer.parseInt(cantidadField.getText());
                String razon = razonField.getText();
                TransaccionInventario.TipoTransaccion tipo = (TransaccionInventario.TipoTransaccion) tipoComboBox.getSelectedItem();
                

                TransaccionInventario transaccion = new TransaccionInventario(producto, cantidad, razon, tipo);
                if (transaccion.realizarTransaccion()) {
                    TransaccionRepositorio.agregarTransaccion(transaccion);
                    JOptionPane.showMessageDialog(this, "Transacción realizada con éxito");
                    dispose();
                    ProductoRepositorio.verificarExistenciasMinimas();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Error: No se pudo realizar la transacción");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: La cantidad debe ser un número entero");
            }
        });
        
        add(realizarButton, BorderLayout.SOUTH);
    }
}

