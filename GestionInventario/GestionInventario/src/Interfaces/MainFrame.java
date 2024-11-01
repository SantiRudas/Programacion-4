/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Rudas
 */
import Interfaces.LoginFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parcial1.ProductoRepositorio;
import parcial1.Usuario;

public class MainFrame extends JFrame{
    private JButton logoutButton;
    private JButton agregarPButton;
    private JButton modificarPButton;
    private JButton eliminarPButton;
    private JButton visualizarPButton;
    private ProductoRepositorio ProductoRepositorio;

    public MainFrame(Usuario usuario) {
        setTitle("Bienvenido");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        ProductoRepositorio = new ProductoRepositorio();
        
        JLabel bienvenidaLabel = new JLabel("<html>Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido() +
        "<br>Su rol es " + usuario.getRol() + "</html>");
        bienvenidaLabel.setBounds(10, 10, 350, 50);
        add(bienvenidaLabel);

        agregarPButton = new JButton("Agregar Producto");
        agregarPButton.setBounds(300, 70, 150, 90);
        add(agregarPButton);
        
        modificarPButton = new JButton("Modificar Producto");
        modificarPButton.setBounds(470, 70, 150, 90);
        add(modificarPButton);
        
        eliminarPButton = new JButton("Eliminar Producto");
        eliminarPButton.setBounds(300, 180, 150, 90);
        add(eliminarPButton);
        
        visualizarPButton = new JButton("Visualizar Producto");
        visualizarPButton.setBounds(470, 180, 150, 90);
        add(visualizarPButton);
        
        
        
        agregarPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProductoFrame agregarProductoFrame = new AgregarProductoFrame(MainFrame.this);
                agregarProductoFrame.setVisible(true);
            }
        });
        
        
        modificarPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificarProductoFrame modificarFrame = new ModificarProductoFrame(MainFrame.this);
                modificarFrame.setVisible(true);
            }
        });
        

        eliminarPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarProductoFrame eliminarFrame = new EliminarProductoFrame(MainFrame.this);
                eliminarFrame.setVisible(true); // Mostrar la ventana modal
            }
        });

     
        visualizarPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisualizarProductoFrame visualizarframe = new VisualizarProductoFrame(MainFrame.this);
                visualizarframe.setVisible(true);
            }
        });


      
        logoutButton = new JButton("Cerrar sesión");
        logoutButton.setBounds(100, 70, 160, 25);
        add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();  
                dispose();  
            }
        });

        setVisible(true);
    }
}
