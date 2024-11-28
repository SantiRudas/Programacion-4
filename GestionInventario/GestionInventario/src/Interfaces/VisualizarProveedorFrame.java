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
import parcial1.Proveedor;
import parcial1.ProveedorRepositorio;

public class VisualizarProveedorFrame extends JDialog {
    private JTable tablaProveedores;
    private JComboBox<Proveedor> proveedorComboBox;
    private JLabel nombreLabel;
    private JLabel direccionLabel;
    private JLabel telefonoLabel;
    private JLabel idLabel;

    public VisualizarProveedorFrame(JFrame parent) {
        super(parent, "Visualizar Proveedores", true);
        setSize(600, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior: tabla de todos los proveedores
        JPanel panelTabla = new JPanel(new BorderLayout());
        tablaProveedores = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaProveedores);
        panelTabla.add(scrollPane, BorderLayout.CENTER);
        add(panelTabla, BorderLayout.CENTER);

        // Cargar los datos en la tabla
        cargarTablaProveedores();

        // Panel inferior: búsqueda específica
        JPanel panelBusqueda = new JPanel(new GridLayout(6, 2, 10, 10));
        panelBusqueda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiqueta y ComboBox para seleccionar proveedor
        panelBusqueda.add(new JLabel("Seleccionar Proveedor:"));
        proveedorComboBox = new JComboBox<>(ProveedorRepositorio.obtenerProveedores().toArray(new Proveedor[0]));
        panelBusqueda.add(proveedorComboBox);

        // Etiquetas para mostrar los datos del proveedor seleccionado
        panelBusqueda.add(new JLabel("ID:"));
        idLabel = new JLabel("-");
        panelBusqueda.add(idLabel);

        panelBusqueda.add(new JLabel("Nombre:"));
        nombreLabel = new JLabel("-");
        panelBusqueda.add(nombreLabel);

        panelBusqueda.add(new JLabel("Dirección:"));
        direccionLabel = new JLabel("-");
        panelBusqueda.add(direccionLabel);

        panelBusqueda.add(new JLabel("Teléfono:"));
        telefonoLabel = new JLabel("-");
        panelBusqueda.add(telefonoLabel);

        add(panelBusqueda, BorderLayout.SOUTH);

        // Listener para actualizar los datos según el proveedor seleccionado
        proveedorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proveedor seleccionado = (Proveedor) proveedorComboBox.getSelectedItem();
                if (seleccionado != null) {
                    idLabel.setText(seleccionado.getId());
                    nombreLabel.setText(seleccionado.getNombre());
                    direccionLabel.setText(seleccionado.getDireccion());
                    telefonoLabel.setText(seleccionado.getTelefono());
                }
            }
        });

        setLocationRelativeTo(parent);
    }

    private void cargarTablaProveedores() {
        // Definir columnas y modelo de la tabla
        String[] columnas = {"ID", "Nombre", "Dirección", "Teléfono"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        // Agregar los datos de los proveedores al modelo
        for (Proveedor proveedor : ProveedorRepositorio.obtenerProveedores()) {
            Object[] fila = {
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getDireccion(),
                proveedor.getTelefono()
            };
            modeloTabla.addRow(fila);
        }

        // Asignar el modelo a la tabla
        tablaProveedores.setModel(modeloTabla);
    }
}

