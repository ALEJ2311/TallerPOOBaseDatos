/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03;

/**
 *
 * @author utpl
 */
public abstract class Producto {
    protected String nombre;
    protected int precio;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract String mostrarPrecio();

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public abstract String getTipo();
}
