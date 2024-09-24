/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;
    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
/**
 *
 * @author Rudas
 */
public class LoginFrame extends JFrame{

    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JButton loginButton;
    private UsuarioServicio usuarioServicio;

    public LoginFrame() {
        usuarioServicio = new UsuarioServicio();

        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Componentes de la interfaz gráfica
        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setBounds(10, 10, 80, 25);
        add(correoLabel);

        correoField = new JTextField();
        correoField.setBounds(100, 10, 160, 25);
        add(correoField);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(10, 40, 80, 25);
        add(contrasenaLabel);

        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(100, 40, 160, 25);
        add(contrasenaField);

        loginButton = new JButton("Ingresar");
        loginButton.setBounds(100, 80, 160, 25);
        add(loginButton);
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = correoField.getText();
                String contrasena = new String(contrasenaField.getPassword());

                if (usuarioServicio.validarUsuario(correo, contrasena)) {
                    Usuario usuario = usuarioServicio.obtenerUsuarioPorCorreo(correo);
                    new MainFrame(usuario);  // Mostrar la pantalla principal
                    dispose();  // Cerrar la ventana de login
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                }
            }
        });
        setVisible(true);
    }
}
