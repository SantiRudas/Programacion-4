/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

/**
 *
 * @author Rudas
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JButton logoutButton;

    public MainFrame(Usuario usuario) {
        setTitle("Bienvenido");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel bienvenidaLabel = new JLabel("Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido());
        bienvenidaLabel.setBounds(10, 10, 250, 25);
        add(bienvenidaLabel);

        logoutButton = new JButton("Cerrar sesión");
        logoutButton.setBounds(100, 50, 160, 25);
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
