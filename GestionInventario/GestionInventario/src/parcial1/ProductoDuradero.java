/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

import java.time.LocalDate;

/**
 *
 * @author Rudas
 */
public class ProductoDuradero extends Producto{
    private int duracionEnMeses;
    private LocalDate fechaDeFabricacion;
    
    public ProductoDuradero(String nombre, String descripcion, String categoria,
            int cantidadInicial, int precio, String unidadDeMedida, int duracionEnMeses, LocalDate fechaDeFabricacion){    
        super(nombre, descripcion, categoria, cantidadInicial, precio, unidadDeMedida);
        this.duracionEnMeses = duracionEnMeses;
        this.fechaDeFabricacion = fechaDeFabricacion;
    }
    
    public boolean esDuradero() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaExpiracion = fechaDeFabricacion.plusMonths(duracionEnMeses);
        
        return fechaActual.isBefore(fechaExpiracion);
    }

    public int getDuracionEnMeses() {
        return duracionEnMeses;
    }

    public void setDuracionEnMeses(int duracionEnMeses) {
        this.duracionEnMeses = duracionEnMeses;
    }

    public LocalDate getFechaDeFabricacion() {
        return fechaDeFabricacion;
    }

    public void setFechaDeFabricacion(LocalDate fechaDeFabricacion) {
        this.fechaDeFabricacion = fechaDeFabricacion;
    }
    
    
}
