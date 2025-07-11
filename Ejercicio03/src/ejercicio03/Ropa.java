/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03;

/**
 *
 * @author utpl
 */
public class Ropa extends Producto {

    public Ropa(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public String mostrarPrecio() {
        return "Precio de la prenda '" + nombre + "': $" + String.format("%d", precio) + " (IVA incluido)";
    }

    @Override
    public String getTipo() {
        return "Ropa";
    }
}
