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
public class ProductoPerecedero extends Producto{
     private LocalDate fechaDeVencimiento;
     
     public ProductoPerecedero(String nombre, String descripcion, String categoria,
            int cantidadInicial, int precio, String unidadDeMedida, String idProducto, LocalDate fechaDeVencimiento){    
        super(nombre, descripcion, categoria, cantidadInicial, precio, unidadDeMedida, idProducto);
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
    
    public boolean esFresco() {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isBefore(fechaDeVencimiento) || fechaActual.isEqual(fechaDeVencimiento);
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
    
    
}
