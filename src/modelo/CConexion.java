package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class CConexion {

    String usuario = "sebatian";
    String contrasena = "#3Programacion3";
    String url = "72.167.84.254/banco";

    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexion correcta");
            return con;
        } catch (Exception e) {
            System.out.println("No se pudo conectar.");
            return null;
        }
    }

    public void desconectar(Connection con) {
        try {
            con.close();
            System.out.println("Se cerró la conexión");
        } catch (Exception e) {
            System.out.println("No se pudo desconectar.");
        }
    }  
}