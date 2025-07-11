/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03;

/**
 *
 * @author utpl
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nombreBase = "jdbc:sqlite:productos.db";
        Scanner entrada = new Scanner(System.in);

        GestorBaseDatos gestor = new GestorBaseDatos(nombreBase);

        boolean continuar = true;
        while (continuar) {
            System.out.println("ingrese tipo de producto (Electronico / Ropa)");
            String tipo = entrada.nextLine().trim();

            if (!tipo.equalsIgnoreCase("electronico") && !tipo.equalsIgnoreCase("ropa")) {
                System.out.println("tipo inválido, solo se acepta Electronico o Ropa");
                continue;
            }

            System.out.println("Ingrese nombre");
            String nombre = entrada.nextLine().trim();

            System.out.println("Ingrese precio");
            int precio = entrada.nextInt();
            entrada.nextLine();

            Producto producto;
            if (tipo.equalsIgnoreCase("electronico")) {
                producto = new Electronico(nombre, precio);
            } else {
                producto = new Ropa(nombre, precio);
            }

            gestor.insertarProducto(producto);
            System.out.println("Producto agregado " + producto.mostrarPrecio());

            System.out.println("Desea agregar otro producto? (S/N)");
            String resp = entrada.nextLine().trim();
            if (!resp.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        gestor.mostrarProductos();
    }
}
