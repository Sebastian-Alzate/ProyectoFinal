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

    public int IngresarCajero(int ndiez, int nveinte, int ncincuenta, int ncien) {
        conecta = con.conectar();
        int x = consulta.IngresarCajero(conecta, ndiez, nveinte, ncincuenta, ncien);
        con.desconectar(conecta);
        return x;
    }

    public int EditarCajero(int idcajero, int ndiez, int nveinte, int ncincuenta, int ncien) {
        conecta = con.conectar();
        int x = consulta.EditarCajero(conecta, idcajero, ndiez, nveinte, ncincuenta, ncien);
        con.desconectar(conecta);
        return x;
    }

    public int EliminarCajero(int idcajero) {
        conecta = con.conectar();
        int x = consulta.EliminarCajero(conecta, idcajero);
        con.desconectar(conecta);
        return x;
    }

    public int AgregarBilletesCajero(int idcajero, int ndiez, int nveinte, int ncincuenta, int ncien) {
        conecta = con.conectar();
        int x = consulta.AgregarBilletesCajero(conecta, idcajero, ndiez, nveinte, ncincuenta, ncien);
        con.desconectar(conecta);
        return x;
    }

    public int QuitarBilletesCajero(int idcajero, int ndiez, int nveinte, int ncincuenta, int ncien) {
        conecta = con.conectar();
        int x = consulta.QuitarBilletesCajero(conecta, idcajero, ndiez, nveinte, ncincuenta, ncien);
        con.desconectar(conecta);
        return x;
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

    public int IngresarCliente(String nombre, String apellido, String telefono, String ciudad, int ncuenta, double saldo) {
        conecta = con.conectar();
        int x = consulta.IngresarCliente(conecta, nombre, apellido, telefono, ciudad, ncuenta, saldo);
        con.desconectar(conecta);
        return x;
    }

    public int EditarCliente(int idcliente, String nombre, String apellido, String telefono, String ciudad, int ncuenta, double saldo) {
        conecta = con.conectar();
        int x = consulta.EditarCliente(conecta, idcliente, nombre, apellido, telefono, ciudad, ncuenta, saldo);
        con.desconectar(conecta);
        return x;
    }

    public int EliminarCliente(int idcliente) {
        conecta = con.conectar();
        int x = consulta.EliminarCliente(conecta, idcliente);
        con.desconectar(conecta);
        return x;
    }

    public ArrayList<CClientes> BuscarPorNombre(String nombre) {
        ArrayList<CClientes> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.BuscarPorNombre(conecta, nombre);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }

    public ArrayList<CClientes> BuscarPorId(int idcliente) {
        ArrayList<CClientes> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.BuscarPorId(conecta, idcliente);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public int ConsignarDineroCliente(int idcliente, double dinero) {
        conecta = con.conectar();
        int x = consulta.ConsignarDineroCliente(conecta, idcliente, dinero);
        con.desconectar(conecta);
        return x;
    }
    
    public int RetirarDineroCliente(int idcliente, double dinero) {
        conecta = con.conectar();
        int x = consulta.RetirarDineroCliente(conecta, idcliente, dinero);
        con.desconectar(conecta);
        return x;
    }
}
