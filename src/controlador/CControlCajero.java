package controlador;

import java.sql.Connection;
import java.util.HashMap;
import modelo.*;

public class CControlCajero {

    CConexion con = new CConexion();
    Connection conecta;
    CConsultasCajero consulta = new CConsultasCajero();

    public CControlCajero() {
    }

    public int RetirarDineroClienteCajero(int idcliente, int ncuenta, int idcajero, int dinero) {
        conecta = con.conectar();
        int x = consulta.RetirarDineroClienteCajero(conecta, idcliente, ncuenta, idcajero, dinero);
        con.desconectar(conecta);
        return x;
    }

    public String getResultado() {
        return consulta.getResultado();
    }

    public HashMap<Integer, Integer> getCajero() {
        return consulta.getCajero();
    }
}
