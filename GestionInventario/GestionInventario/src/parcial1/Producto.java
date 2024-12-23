/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

/**
 *
 * @author Rudas
 */
public class Producto {
    private String nombre;
    private String descripcion;
    private String categoria;
    private int cantidadInicial;
    private int precio;
    private String unidadDeMedida;
    private String idProducto;
    public static final int CANTIDAD_MINIMA_DEFAULT = 10;
    
    
    public Producto(){}
    
    public Producto(String nombre, String descripcion, String categoria,
            int cantidadInicial, int precio, String unidadDeMedida, String idProducto)
    {    
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cantidadInicial = cantidadInicial;
        this.precio = precio;
        this.unidadDeMedida = unidadDeMedida;
        this.idProducto = idProducto;
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadMinima() {
        return CANTIDAD_MINIMA_DEFAULT; // Siempre devuelve el valor de la constante
    }
    
    
    
}


