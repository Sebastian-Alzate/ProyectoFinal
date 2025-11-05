package modelo;

import java.sql.*;
import java.util.ArrayList;

public class CConsultasAdministracion {
    
    Connection con;
    String query;

    public CConsultasAdministracion() {

    }
    
    public ArrayList<CCajeros> ListarCajeros(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos";
        ArrayList<CCajeros> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CCajeros c = new CCajeros(
                        resultado.getInt("id"),
                        resultado.getInt("ndiez"),
                        resultado.getInt("nveinte"),
                        resultado.getInt("ncincuenta"),
                        resultado.getInt("ncien"),
                        resultado.getInt("estado"));
                lista.add(c);
            }
            System.out.println("Consulta correcta.");
            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }
    
    public ArrayList<CClientes> ListarClientes(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos";
        ArrayList<CClientes> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CClientes c = new CClientes(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("telefono"),
                        resultado.getString("ciudad"),
                        resultado.getInt("ncuenta"),
                        resultado.getDouble("saldo"),
                        resultado.getInt("estado"));
                lista.add(c);
            }
            System.out.println("Consulta correcta.");
            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }
}
