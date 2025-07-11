/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Personal
 */
public abstract class Vehiculos {
    
    String modelo;
    String marca;

    public Vehiculos(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }
    
    public abstract void mostrarInfo();
}
