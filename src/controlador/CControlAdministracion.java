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
        if (conecta != null){
            lista = consulta.ListarCajeros(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
}
