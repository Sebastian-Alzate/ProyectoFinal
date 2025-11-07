package controlador;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.*;

public class CControlAdministracion {

    CConexion con = new CConexion();
    Connection conecta;
    CConsultasAdministracion consulta = new CConsultasAdministracion();

    public CControlAdministracion() {

    }

    public ArrayList<CCajeros> ListarCajeros() {
        ArrayList<CCajeros> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.ListarCajeros(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }

    public boolean IngresarCajero(int ndiez, int nveinte, int ncincuenta, int ncien) {
        conecta = con.conectar();
        boolean bandera = consulta.IngresarCajero(conecta, ndiez, nveinte, ncincuenta, ncien);
        con.desconectar(conecta);
        return bandera;
    }
    
    public boolean EditarCajero(int idcajero, int ndiez, int nveinte, int ncincuenta, int ncien) {
        conecta = con.conectar();
        boolean bandera = consulta.EditarCajero(conecta, idcajero, ndiez, nveinte, ncincuenta, ncien);
        con.desconectar(conecta);
        return bandera;
    }
    
    public boolean EliminarCajero(int idcajero) {
        conecta = con.conectar();
        boolean bandera = consulta.EliminarCajero(conecta, idcajero);
        con.desconectar(conecta);
        return bandera;
    }

    public ArrayList<CClientes> ListarClientes() {
        ArrayList<CClientes> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.ListarClientes(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
}
