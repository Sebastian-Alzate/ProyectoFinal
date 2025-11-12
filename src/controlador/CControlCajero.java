package controlador;

import java.sql.Connection;
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
}
