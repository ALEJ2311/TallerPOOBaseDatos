/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03;

/**
 *
 * @author utpl
 */
public class Electronico extends Producto {

    public Electronico(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public String mostrarPrecio() {
        return "Precio del electrónico '" + nombre + "': $" + String.format("%d", precio);
    }

    @Override
    public String getTipo() {
        return "Electronico";
    }
}
