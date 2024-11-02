/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

/**
 *
 * @author Rudas
 */
public class UsuarioServicio {
    private UsuarioRepositorio usuarioRepositorio;
    
    //constructor
    public UsuarioServicio(){
        this.usuarioRepositorio = new UsuarioRepositorio();
        
        
    }
    
    public boolean validarUsuario(String correo, String contraseña){
        for(Usuario usuario : UsuarioRepositorio.obtenerListadoUsuarios()){
            if(usuario.getCorreo().equals(correo) && usuario.getContrasenia().equals(contraseña)){
                if(usuario.isActivo()){
                    return true;
                }
                else{
                    System.out.println("El usuario esta inactivo, no puede iniciar sesion");
                    return false;
                }
            }
        }
        return false;
    }
    
    public Usuario obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepositorio.buscarUsuarioPorCorreo(correo);
    }
}
