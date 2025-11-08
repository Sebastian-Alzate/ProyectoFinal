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
        ArrayList<CCajeros> lista = new ArrayList<>();
        try {
            query = "SELECT * FROM cajeros";
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
            System.out.println("Cajeros consultados.");
            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public boolean IngresarCajero(Connection con, int ndiez, int nveinte, int ncincuenta, int ncien) {
        this.con = con;
        try {
            query = "INSERT INTO cajeros (id, ndiez, nveinte, ncincuenta, ncien, estado) VALUES (NULL, " + ndiez + ", " + nveinte + ", " + ncincuenta + ", " + ncien + ",0);";
            PreparedStatement preparar = con.prepareStatement(query);
            preparar.executeUpdate();
            System.out.println("Cajero ingresado.");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public boolean EditarCajero(Connection con, int idcajero, int ndiez, int nveinte, int ncincuenta, int ncien) {
        this.con = con;
        try {
            query = "SELECT estado FROM cajeros WHERE id=" + idcajero + ";";
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();
            if (resultado.next()) {
                if (resultado.getInt("estado") != 1) {
                    //Poner el cajero en ocupado.
                    query = "UPDATE cajeros SET estado=1 WHERE id=" + idcajero + ";";
                    PreparedStatement preparar1 = con.prepareStatement(query);
                    preparar1.executeUpdate();

                    //Editar el cajero y ponerlo libre de una vez.
                    query = "UPDATE cajeros SET ndiez=" + ndiez + ", nveinte=" + nveinte + ", ncincuenta=" + ncincuenta + ", ncien=" + ncien + ", estado=0 WHERE id=" + idcajero + ";";
                    PreparedStatement preparar2 = con.prepareStatement(query);
                    preparar2.executeUpdate();
                    System.out.println("Cajero editado.");
                    return true;
                } else {
                    System.out.println("Cajero ocupado.");
                    return false;
                }
            } else {
                System.out.println("No existe un cajero con este id.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public boolean EliminarCajero(Connection con, int idcajero) {
        this.con = con;
        try {
            query = "SELECT estado FROM cajeros WHERE id=" + idcajero + ";";
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();
            if (resultado.next()) {
                if (resultado.getInt("estado") != 1) {
                    //Poner el cajero en ocupado.
                    query = "UPDATE cajeros SET estado=1 WHERE id=" + idcajero + ";";
                    PreparedStatement preparar1 = con.prepareStatement(query);
                    preparar1.executeUpdate();

                    //Eliminar el cajero.
                    query = "DELETE FROM cajeros WHERE id=" + idcajero + ";";
                    PreparedStatement preparar2 = con.prepareStatement(query);
                    preparar2.executeUpdate();
                    System.out.println("Cajero eliminado.");
                    return true;
                } else {
                    System.out.println("Cajero ocupado.");
                    return false;
                }
            } else {
                System.out.println("No existe un cajero con este id.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public ArrayList<CClientes> ListarClientes(Connection con) {
        this.con = con;
        ArrayList<CClientes> lista = new ArrayList<>();
        try {
            query = "SELECT * FROM clientes";
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

    public boolean IngresarCliente(Connection con, String nombre, String apellido, String telefono, String ciudad, int ncuenta, double saldo) {
        this.con = con;
        try {
            query = "INSERT INTO clientes (id, nombre, apellido, telefono, ciudad, ncuenta, saldo, estado) VALUES (NULL, " + nombre + ", " + apellido + ", " + telefono + ", " + ciudad + ", " + ncuenta + ", " + saldo + ",0);";
            PreparedStatement preparar = con.prepareStatement(query);
            preparar.executeUpdate();
            System.out.println("Cliente ingresado.");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public boolean EditarCliente(Connection con, int idcliente, String nombre, String apellido, String telefono, String ciudad, int ncuenta, double saldo) {
        this.con = con;
        try {
            query = "SELECT estado FROM clientes WHERE id=" + idcliente + ";";
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();
            if (resultado.next()) {
                if (resultado.getInt("estado") != 1) {
                    //Poner el cliente en ocupado.
                    query = "UPDATE clientes SET estado=1 WHERE id=" + idcliente + ";";
                    PreparedStatement preparar1 = con.prepareStatement(query);
                    preparar1.executeUpdate();

                    //Editar el cliente y ponerlo libre de una vez.
                    query = "UPDATE clientes SET nombre='" + nombre + "', apellido='" + apellido + "', telefono='" + telefono + "', ciudad='" + ciudad + "', ncuenta=" + ncuenta + ", saldo=" + saldo + " WHERE id=" + idcliente + ";";
                    PreparedStatement preparar2 = con.prepareStatement(query);
                    preparar2.executeUpdate();
                    System.out.println("Cliente editado.");
                    return true;
                } else {
                    System.out.println("Cliente ocupado.");
                    return false;
                }
            } else {
                System.out.println("No existe un cliente con este id.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public boolean EliminarCliente(Connection con, int idcliente) {
        this.con = con;
        try {
            query = "SELECT estado FROM clientes WHERE id=" + idcliente + ";";
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();
            if (resultado.next()) {
                if (resultado.getInt("estado") != 1) {
                    //Poner el cliente en ocupado.
                    query = "UPDATE clientes SET estado=1 WHERE id=" + idcliente + ";";
                    PreparedStatement preparar1 = con.prepareStatement(query);
                    preparar1.executeUpdate();

                    //Eliminar el cliente.
                    query = "DELETE FROM clientes WHERE id=" + idcliente + ";";
                    PreparedStatement preparar2 = con.prepareStatement(query);
                    preparar2.executeUpdate();
                    System.out.println("Cliente eliminado.");
                    return true;
                } else {
                    System.out.println("Cliente ocupado.");
                    return false;
                }
            } else {
                System.out.println("No existe un cliente con este id.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public ArrayList<CClientes> BuscarPorNombre(Connection con, String nombre) {
        this.con = con;
        ArrayList<CClientes> lista = new ArrayList<>();
        try {
            query = "SELECT * FROM clientes WHERE nombre LIKE '%" + nombre + "%';";
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
            System.out.println("Clientes consultados por un nombre determinado.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CClientes> BuscarPorId(Connection con, int idcliente) {
        this.con = con;
        ArrayList<CClientes> lista = new ArrayList<>();
        try {
            query = "SELECT * FROM clientes WHERE id=" + idcliente + ";";
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
            System.out.println("Cliente consultado por un id determinado.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }
}
