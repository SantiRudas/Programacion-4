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
    
    public static void crearUsuario(Usuario usuario){
        usuarios.add(usuario);
        System.out.println("Usuario creado existosamente");
    }
    
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
               usuario.setCorreo(usuarioModificado.getCorreo());
               usuario.setCorreo(usuarioModificado.getContrasenia());
               usuario.setRol(usuarioModificado.getRol());
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
                System.out.println("Correo: " + usuario.getCorreo());
                System.out.println("Contrasena: "+ usuario.getContrasenia());
                System.out.println("Rol: " + usuario.getRol());
                System.out.println("---------------------------");
                return usuario;
            }
        }
        System.out.println("Usuario No encontrado");
        return null;
    }
    
    public static Usuario buscarUsuarioPorCorreo(String correo){
        for(Usuario usuario : usuarios){
            if(usuario.getCorreo().equals(correo)){
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Apellido: " + usuario.getApellido());
                System.out.println("Tipo de Documento: " + usuario.getTipoDocumentoIdentidad());
                System.out.println("Numero de Documento: " + usuario.getNumeroDocumentoIdentidad());
                System.out.println("Direccion: " + usuario.getDireccion());
                System.out.println("Telefono: " + usuario.getTelefono());
                System.out.println("Activo: " + (usuario.isActivo() ? "Si" : "No"));
                System.out.println("Correo: " + usuario.getCorreo());
                System.out.println("Contrasena: " + usuario.getContrasenia());
                System.out.println("Rol: " + usuario.getRol());
                System.out.println("---------------------------");
                return usuario;
            }
        }
        System.out.println("Usuario No encontrado");
        return null;
    }
    
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
            System.out.println("Correo: " + usuario.getCorreo());
            System.out.println("Contrasena: "+ usuario.getContrasenia());
            System.out.println("Rol: " + usuario.getRol());
            System.out.println("---------------------------"); // Separador entre usuarios
        }
    }
    
    public static ArrayList<Usuario> obtenerListadoUsuarios(){
        return usuarios;
    }
    
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
    
    public static void inactivarUsuario(int id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                usuario.setActivo(false);
                System.out.println("Usuario inactivado exitosamente");
                return;
            }
        }
        System.out.println("Usuario No encontrado");
    }
    
    
    public static void modificarAtributoUsuario(int id, String atributo, Object nuevoAtributo){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                switch(atributo.toLowerCase()){
                    case "nombre":
                        usuario.setNombre((String) nuevoAtributo);
                        break;
                        
                    case "apellido":
                        usuario.setApellido((String) nuevoAtributo);
                        break;
                        
                    case "tipodocumento":
                        usuario.setTipoDocumentoIdentidad((String) nuevoAtributo);
                        break;
                        
                    case "numerodocumento":
                        usuario.setNumeroDocumentoIdentidad((String) nuevoAtributo);
                        break;
                        
                    case "direccion":
                        usuario.setDireccion((String) nuevoAtributo);
                        break;
                        
                    case "telefono":
                        usuario.setTelefono((String) nuevoAtributo);
                        break;
                        
                    case "estado":
                        usuario.setActivo((Boolean) nuevoAtributo);
                        break;
                        
                    case "correo":
                        usuario.setCorreo((String) nuevoAtributo);
                        break;
                        
                    case "contraseña":
                        usuario.setContrasenia((String) nuevoAtributo);
                        break;
                        
                    case "rol":
                        usuario.setRol((String) nuevoAtributo);
                        
                    default:
                        System.out.println("Atributo no valido");
                        return;
                }
                System.out.println("Atributo " + atributo + " modificado exitosamente");
                return;
            }
        }
    }
}
