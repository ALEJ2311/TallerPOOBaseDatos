/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03;

/**
 *
 * @author utpl
 */
import java.sql.*;

public class GestorBaseDatos {
    private Connection conexion;
    private Statement statement;

    public GestorBaseDatos(String nombreBase) {
        try {
            conexion = DriverManager.getConnection(nombreBase);
            statement = conexion.createStatement();
            crearTabla();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private void crearTabla() throws SQLException {
        String sqlCrear = "CREATE TABLE IF NOT EXISTS productos (" +
                          "tipo TEXT NOT NULL, " +
                          "nombre TEXT NOT NULL, " +
                          "precio INT NOT NULL)";
        statement.execute(sqlCrear);
}

    public void insertarProducto(Producto producto) {
        try {
            String sqlInsertar = String.format(
                "INSERT INTO productos(tipo, nombre, precio) VALUES('%s', '%s', %d)",
                producto.getTipo(), producto.getNombre(), producto.getPrecio()
            );
            statement.execute(sqlInsertar);
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public void mostrarProductos() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM productos");
            System.out.println("\nProductos guardados:");
            while (rs.next()) {
                System.out.printf("%s | %s | %.2f\n",
                    rs.getString("tipo"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar productos: " + e.getMessage());
        }
    }
}
