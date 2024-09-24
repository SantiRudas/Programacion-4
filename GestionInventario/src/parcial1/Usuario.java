/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

/**
 *
 * @author Rudas
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String tipoDocumentoIdentidad;
    private String numeroDocumentoIdentidad;
    private String direccion;
    private String telefono;
    private Boolean activo;
    
    public Usuario() {}
    
    public Usuario(int id, String nombre, String apellido, 
            String tipoDocumentoIdentidad, String numeroDocumentoIdentidad,
            String direccion, String telefono, Boolean activo)
    {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getNumeroDocumentoIdentidad() {
        return numeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }      
}
