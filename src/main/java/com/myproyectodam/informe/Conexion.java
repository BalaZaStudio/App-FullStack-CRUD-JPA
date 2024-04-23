package com.myproyectodam.informe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Par�metros de conexi�n
    private static final String URL = "jdbc:mysql://localhost:3306/login";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    // M�todo para obtener la conexi�n
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Registrar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexi�n
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexi�n establecida correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    // M�todo para cerrar la conexi�n
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexi�n cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexi�n: " + e.getMessage());
            }
        }
    }

   
}


