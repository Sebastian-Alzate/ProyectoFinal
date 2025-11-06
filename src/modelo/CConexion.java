package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class CConexion {

    String usuario = "sebastian";
    String contrasena = "#3Programacion3";
    String url = "jdbc:mysql://72.167.84.254/banco";

    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión correcta.");
            return con;
        } catch (Exception e) {
            System.out.println("No se puedo conectar.");
            return null;
        }
    }

    public void desconectar(Connection con) {
        try {
            con.close();
            System.out.println("Se cerró la conexión.");
        } catch (Exception e) {
            System.out.println("No se pudo desconectar.");
        }
    }
}
