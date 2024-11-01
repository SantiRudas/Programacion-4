/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcial1;

import java.time.LocalDate;

/**
 *
 * @author Rudas
 */
public class Parcial1 {

    public static void main(String[] args) {
        UsuarioServicio usuarioServicio = new UsuarioServicio();

        // Crear usuarios de ejemplo
        Usuario usuario1 = new Usuario(1, "Santiago", "Rudas", "CC", "1004754881", "Calle 6 #26-78", "3127969513", false, "santiago", "1234", "administrador");
        Usuario usuario2 = new Usuario(2, "Gustavo", "Castañeda", "CC", "10000001", "Calle 5 #26-78", "3005647890", true, "gustavo@gmail.com", "4321", "auxiliar");
        
        // Agregar los usuarios al servicio
        UsuarioRepositorio.crearUsuario(usuario1);
        UsuarioRepositorio.crearUsuario(usuario2);
        
        UsuarioRepositorio.mostrarListadoUsuarios();
        
        UsuarioRepositorio.activarUsuario(1);
        
        //UsuarioRepositorio.inactivarUsuario(2);
        
        UsuarioRepositorio.modificarAtributoUsuario(2, "tipodocumento", "TI");
        
        UsuarioRepositorio.mostrarListadoUsuarios();
        //UsuarioRepositorio.buscarUsuarioPorDocumento("10000001");
        //UsuarioRepositorio.buscarUsuarioPorDocumento("1004754881");
        
        // Ejemplo de agregar productos al repositorio
        ProductoRepositorio.agregarProducto(new ProductoPerecedero("Leche", "Leche entera", "Lácteos", 10, 2000, "Litros", LocalDate.of(2024, 11, 15)));
        ProductoRepositorio.agregarProducto(new ProductoDuradero("Mesa", "Mesa de madera", "Muebles", 5, 150000, "Unidades", 60, LocalDate.of(2023, 10, 01)));

        
        new LoginFrame();
    }
    
}
