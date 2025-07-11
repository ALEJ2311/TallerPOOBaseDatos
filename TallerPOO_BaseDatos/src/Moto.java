/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Personal
 */
public class Moto extends Vehiculos{
    
    public Moto(String modelo, String marca) {
        super(modelo, marca);
    }

    @Override
    public void mostrarInfo() {
        System.out.println(String.format("Moto:\nMarca: %s\nModelo: %s", marca, modelo));
    }
    
}
