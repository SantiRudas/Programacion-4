/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcial1;

/**
 *
 * @author Rudas
 */
public class Parcial1 {

    public static void main(String[] args) {
        UsuarioServicio usuarioServicio = new UsuarioServicio();

        // Crear usuarios de ejemplo
        Usuario usuario1 = new Usuario(1, "Santiago", "Rudas", "CC", "1004754881", "Calle 6 #26-78", "1234", true);
        Usuario usuario2 = new Usuario(2, "Carlos", "Ramirez", "CC", "10000001", "Calle 5 #26-78", "4321", false);
        
        // Agregar los usuarios al servicio
        UsuarioRepositorio.crearUsuario(usuario1);
        UsuarioRepositorio.crearUsuario(usuario2);
        
        UsuarioRepositorio.mostrarListadoUsuarios();
        
        //UsuarioRepositorio.buscarUsuarioPorDocumento("1004754881");
        
        UsuarioRepositorio.activarUsuario(2);
        
        UsuarioRepositorio.buscarUsuarioPorDocumento("10000001");
        
        UsuarioRepositorio.inactivarUsuario(1);
        
        UsuarioRepositorio.buscarUsuarioPorDocumento("1004754881");
        
        new LoginFrame();
    }
    
}