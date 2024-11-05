/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

public class TransaccionInventario {
    private Producto producto;
    private int cantidad;
    private String razon;
    private TipoTransaccion tipo;

    public enum TipoTransaccion {
        AGREGAR,
        DISMINUIR
    }

    public TransaccionInventario(Producto producto, int cantidad, String razon, TipoTransaccion tipo) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.razon = razon;
        this.tipo = tipo;
    }

    public boolean realizarTransaccion() {
        if (tipo == TipoTransaccion.DISMINUIR) {
            if (producto.getCantidadInicial() >= cantidad) {
                producto.setCantidadInicial(producto.getCantidadInicial() - cantidad);
                return true;
            } else {
                System.out.println("Error: No hay suficientes existencias para reducir en la cantidad solicitada.");
                return false;
            }
        } else if (tipo == TipoTransaccion.AGREGAR) {
            producto.setCantidadInicial(producto.getCantidadInicial() + cantidad);
            return true;
        }
        return false;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getRazon() {
        return razon;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }
}

