/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;
    import java.util.ArrayList;
    import java.util.List;
    import javax.swing.JOptionPane;
/**
 *
 * @author Rudas
 */
public class TransaccionRepositorio {
    private static ArrayList <TransaccionInventario> transacciones = new ArrayList<>();
    
    public static void agregarTransaccion(TransaccionInventario transaccion){
        transacciones.add(transaccion);
    }
    
    public static List<TransaccionInventario> obtenerTransacciones() {
        return new ArrayList<>(transacciones); // Retorna una copia de la lista de productos
    }
    
    public static void realizarTransaccionCompra(Producto producto, int cantidadFaltante) {
    // Crear la transacción de compra
        TransaccionInventario transaccionCompra = new TransaccionInventario(
            producto,
            cantidadFaltante,
            "Compra automática para restablecer inventario",
            TransaccionInventario.TipoTransaccion.AGREGAR
        );

    // Realizar la transacción
        if (transaccionCompra.realizarTransaccion()) {
        // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Transacción de compra realizada con éxito.");
        // Agregar la transacción al historial
            TransaccionRepositorio.agregarTransaccion(transaccionCompra);
        } else {
        // Si no se pudo realizar la transacción, mostrar un error
            JOptionPane.showMessageDialog(null, "Error al realizar la compra.");
        }
    }

}
