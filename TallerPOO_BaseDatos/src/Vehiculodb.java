/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Personal
 */
import java.sql.*;


public class Vehiculodb {
    String url = "jdbc:sqlite:Vehiculos.db";

    public Connection conectar() {
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error al conectar con SQLite: " + e.getMessage());
            return null;
        }
    }

    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS vehiculos (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "tipo TEXT, marca TEXT, modelo TEXT)";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    public void guardarVehiculo(String tipo, String marca, String modelo) {
        String sql = "INSERT INTO vehiculos(tipo, marca, modelo) VALUES(?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipo);
            pstmt.setString(2, marca);
            pstmt.setString(3, modelo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar vehículo: " + e.getMessage());
        }
    }

    public void mostrarVehiculos() {
        String sql = "SELECT * FROM vehiculos";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Vehículos Registrados ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");

                System.out.println(id + " - " + tipo.toUpperCase() + " - " + marca + " - " + modelo);
            }

        } catch (SQLException e) {
            System.out.println("Error al leer la base de datos: " + e.getMessage());
        }
    }
}
