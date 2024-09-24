/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

import java.util.ArrayList;

/**
 *
 * @author Rudas
 */
public class UsuarioRepositorio {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    //metodo para agregar un usuario al array
    public static void crearUsuario(Usuario usuario){
        usuarios.add(usuario);
        System.out.println("Usuario creado existosamente");
    }
    
    //metodo para modificar un usuario existente en el array
    public static void modificarUsuario(int id, Usuario usuarioModificado){
       for(Usuario usuario: usuarios){
           if(usuario.getId() == id){
               usuario.setNombre(usuarioModificado.getNombre());
               usuario.setApellido(usuarioModificado.getApellido());
               usuario.setTipoDocumentoIdentidad(usuarioModificado.getTipoDocumentoIdentidad());
               usuario.setNumeroDocumentoIdentidad(usuarioModificado.getNumeroDocumentoIdentidad());
               usuario.setDireccion(usuarioModificado.getDireccion());
               usuario.setTelefono(usuarioModificado.getTelefono());
               usuario.setActivo(usuarioModificado.isActivo());
               System.out.println("Usuario modificado exitosamente");
               return;
           }
       }
        System.out.println("Usuario No encontrado");
    }
    
    //metodo para buscar un usuario por numero de documento en el array
    public static Usuario buscarUsuarioPorDocumento(String numeroDocumento){
        for(Usuario usuario : usuarios){
            if(usuario.getNumeroDocumentoIdentidad().equals(numeroDocumento)){
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Apellido: " + usuario.getApellido());
                System.out.println("Tipo de Documento: " + usuario.getTipoDocumentoIdentidad());
                System.out.println("Numero de Documento: " + usuario.getNumeroDocumentoIdentidad());
                System.out.println("Direccion: " + usuario.getDireccion());
                System.out.println("Telefono: " + usuario.getTelefono());
                System.out.println("Activo: " + (usuario.isActivo() ? "Si" : "No"));
                System.out.println("---------------------------");
                return usuario;
            }
        }
        System.out.println("Usuario No encontrado");
        return null;
    }
    
    public static ArrayList<Usuario> obtenerListadoUsuarios(){
        return usuarios;
    }
    // Método para obtener y mostrar el listado de los usuarios que están en el array
    public static void mostrarListadoUsuarios(){
        System.out.println("Listado de usuarios:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Tipo de Documento: " + usuario.getTipoDocumentoIdentidad());
            System.out.println("Numero de Documento: " + usuario.getNumeroDocumentoIdentidad());
            System.out.println("Direccion: " + usuario.getDireccion());
            System.out.println("Telefono: " + usuario.getTelefono());
            System.out.println("Activo: " + (usuario.isActivo() != null && usuario.isActivo() ? "Si" : "No"));
            System.out.println("---------------------------"); // Separador entre usuarios
        }
    }
    
    //metodo para activar usuario
    public static void activarUsuario(int id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                usuario.setActivo(true);
                System.out.println("Usuario Activado exitosamente");
                return;
            }
        }
        System.out.println("Usuario No encontrado");
    }
    
    //metodo para inactivar usuario
    public static void inactivarUsuario(int id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                usuario.setActivo(false);
                System.out.println("UsuarioIinactivado exitosamente");
                return;
            }
        }
        System.out.println("Usuario No encontrado");
    }
}
