/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rudas
 */
public class ProveedorRepositorio {
    private static ArrayList <Proveedor> proveedores = new ArrayList<>();
    
    public static void agregarProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
        System.out.println("Proveedor creado exitosamente");
    }
    
    public static void eliminarProveedor(Proveedor proveedor) {
        if (proveedores.contains(proveedor)) {
            proveedores.remove(proveedor);
        } else {
            throw new IllegalArgumentException("El proveedor no existe en el repositorio.");
        }
    }
    
    public static void actualizarProveedor(Proveedor proveedorActualizado) {
        for (int i = 0; i < proveedores.size(); i++) {
            Proveedor proveedor = proveedores.get(i);
            if (proveedor.getNombre().equals(proveedorActualizado.getNombre())) {
                // Actualiza los atributos
                proveedor.setDireccion(proveedorActualizado.getDireccion());
                proveedor.setTelefono(proveedorActualizado.getTelefono());
            }
        }
    }
    
    public static List<Proveedor> obtenerProveedores() {
        return new ArrayList<>(proveedores); // Retorna una copia de la lista de productos
    }
}
