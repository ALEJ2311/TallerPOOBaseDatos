
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Personal
 */
public class Main {

    public static void main(String[] args) {
        Vehiculodb db = new Vehiculodb();
        Scanner tcl = new Scanner(System.in);

        db.crearTabla();

        System.out.println("GESTION DE VEHICULOS USANDO SQLITE");
        System.out.print("Ingrese el numero de vehiculos que desea ingresar: ");
        int num = tcl.nextInt();
        tcl.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.println("Vehiculo " + (i + 1));
            System.out.print("Es Auto / Moto ? (ingrese: Auto / Moto): ");
            String tipo = tcl.nextLine();
            System.out.print("Ingrese la marca: ");
            String marca = tcl.nextLine();
            System.out.print("Ingrese el modelo: ");
            String modelo = tcl.nextLine();

            if (tipo.toLowerCase().equalsIgnoreCase("auto")) {
                Vehiculos auto = new Auto(modelo, marca);
                db.guardarVehiculo(tipo, marca, modelo);
            } else {
                if (tipo.toLowerCase().equalsIgnoreCase("moto")) {
                    Vehiculos moto = new Moto(modelo, marca);
                    db.guardarVehiculo(tipo, marca, modelo);
                }
            }
        }
        
        db.mostrarVehiculos();
        
        System.out.println("FIN");
    }
}
