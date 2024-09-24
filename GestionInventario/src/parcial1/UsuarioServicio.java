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
    
    //metodo validacion usuario, se asume que el correo es el numero de documento y la contraseña es el telefono
    public boolean validarUsuario(String correo, String contraseña){
        for(Usuario usuario : UsuarioRepositorio.obtenerListadoUsuarios()){
            if(usuario.getNumeroDocumentoIdentidad().equals(correo) && usuario.getTelefono().equals(contraseña)){
                return true;
            }
        }
        return false;
    }
    
    public Usuario obtenerUsuarioPorDocumento(String correo) {
        return usuarioRepositorio.buscarUsuarioPorDocumento(correo);
    }
}
