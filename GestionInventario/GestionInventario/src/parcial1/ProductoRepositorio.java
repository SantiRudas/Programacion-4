/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Rudas
 */
public class ProductoRepositorio {
    
    private static ArrayList<Producto> productos = new ArrayList<>();
    
    public static void agregarProducto(Producto producto){
        productos.add(producto);
        System.out.println("Producto creado exitosamente");
    }
    
    public static void eliminarProducto(Producto producto) {
        if (productos.contains(producto)) {
            productos.remove(producto);
        } else {
            throw new IllegalArgumentException("El producto no existe en el repositorio.");
        }
    }
    
    // Método para actualizar un producto existente
    public static void actualizarProducto(Producto productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getNombre().equals(productoActualizado.getNombre())) {
                // Actualiza los atributos
                producto.setDescripcion(productoActualizado.getDescripcion());
                producto.setCategoria(productoActualizado.getCategoria());
                producto.setCantidadInicial(productoActualizado.getCantidadInicial());
                producto.setPrecio(productoActualizado.getPrecio());
                producto.setUnidadDeMedida(productoActualizado.getUnidadDeMedida());
                
                // Verifica si el producto es perecedero o duradero y actualiza los campos específicos
                if (producto instanceof ProductoPerecedero && productoActualizado instanceof ProductoPerecedero) {
                    ((ProductoPerecedero) producto).setFechaDeVencimiento(((ProductoPerecedero) productoActualizado).getFechaDeVencimiento());
                } else if (producto instanceof ProductoDuradero && productoActualizado instanceof ProductoDuradero) {
                    ((ProductoDuradero) producto).setDuracionEnMeses(((ProductoDuradero) productoActualizado).getDuracionEnMeses());
                    ((ProductoDuradero) producto).setFechaDeFabricacion(((ProductoDuradero) productoActualizado).getFechaDeFabricacion());
                }
                break;
            }
        }
    }
    
    // Método para obtener la lista de productos
    public static List<Producto> obtenerProductos() {
        return new ArrayList<>(productos); // Retorna una copia de la lista de productos
    }
    

    // Método para mostrar todos los productos
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : productos) {
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Descripción: " + producto.getDescripcion());
                System.out.println("Categoría: " + producto.getCategoria());
                System.out.println("Cantidad Inicial: " + producto.getCantidadInicial());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Unidad de Medida: " + producto.getUnidadDeMedida());
                System.out.println("-------------------------");
            }
        }
    }
}
