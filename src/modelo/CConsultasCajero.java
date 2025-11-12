package modelo;

import java.sql.*;
import java.util.HashMap;

public class CConsultasCajero {

    Connection con;
    String query;

    public CConsultasCajero() {
    }

    public int RetirarDineroClienteCajero(Connection con, int idcliente, int ncuenta, int idcajero, int dinero) {
        this.con = con;
        try {
            
            query = "SELECT saldo, estado FROM clientes WHERE ncuenta=" + ncuenta + " AND id=" + idcliente + ";";
            PreparedStatement preparar1 = con.prepareStatement(query);
            ResultSet resultado1 = preparar1.executeQuery();

            if (!resultado1.next()) {
                System.out.println("El cliente no existe.");
                return 2;
            }

            if (resultado1.getInt("estado") == 1) {
                System.out.println("Cliente ocupado.");
                return 8;
            }

            double saldo = resultado1.getDouble("saldo");

            if (saldo < dinero) {
                System.out.println("Saldo insuficiente.");
                return 3;
            }

            query = "SELECT ndiez, nveinte, ncincuenta, ncien, estado FROM cajeros WHERE id=" + idcajero + ";";
            PreparedStatement preparar2 = con.prepareStatement(query);
            ResultSet resultado2 = preparar2.executeQuery();

            if (!resultado2.next()) {
                System.out.println("El cajero no existe.");
                return 4;
            }

            if (resultado2.getInt("estado") == 1) {
                System.out.println("Cajero ocupado.");
                return 9;
            }

            query = "UPDATE clientes SET estado=1 WHERE ncuenta=" + ncuenta + " AND id=" + idcliente + ";";
            PreparedStatement preparar3 = con.prepareStatement(query);
            preparar3.executeUpdate();

            query = "UPDATE cajeros SET estado=1 WHERE id=" + idcajero + ";";
            PreparedStatement preparar4 = con.prepareStatement(query);
            preparar4.executeUpdate();

            HashMap<Integer, Integer> cajero = new HashMap<>();
            cajero.put(10000, resultado2.getInt("ndiez"));
            cajero.put(20000, resultado2.getInt("nveinte"));
            cajero.put(50000, resultado2.getInt("ncincuenta"));
            cajero.put(100000, resultado2.getInt("ncien"));

            if (dinero % 10000 != 0) {
                System.out.println("Monto no permitido, solo múltiplos de 10.000.");
                return 5;
            }

            if (dinero < 10000 || dinero > 1000000) {
                System.out.println("Monto no permitido, solo se puede entre 10.000 y 1.000.000.");
                return 6;
            }

            boolean retiroValido = true;
            int restante = dinero;
            
            int[] valores = {100000, 50000, 20000, 10000};
            int disponibles;
            int cantidadNecesaria;
            int cantidad;

            for (int valor : valores) {
                disponibles = cajero.get(valor);
                cantidadNecesaria = restante / valor;

                if (cantidadNecesaria > disponibles) {
                    cantidad = disponibles;
                } else {
                    cantidad = cantidadNecesaria;
                }

                if (cantidad > 0) {
                    cajero.replace(valor, cajero.get(valor) - cantidad);
                    restante -= valor * cantidad;
                }
            }

            if (restante != 0) {
                retiroValido = false;
            }

            if (!retiroValido) {
                System.out.println("No hay billetes suficientes para retirar.");
                
                query = "UPDATE clientes SET estado=0 WHERE ncuenta=" + ncuenta + " AND id=" + idcliente + ";";
                PreparedStatement preparar5 = con.prepareStatement(query);
                preparar5.executeUpdate();

                query = "UPDATE cajeros SET estado=0 WHERE id=" + idcajero + ";";
                PreparedStatement preparar6 = con.prepareStatement(query);
                preparar6.executeUpdate();

                return 7;
            }

            saldo -= dinero;
            
            query = "UPDATE clientes SET saldo=" + saldo + ", estado=0 WHERE ncuenta=" + ncuenta + " AND id=" + idcliente + ";";
            PreparedStatement preparar7 = con.prepareStatement(query);
            preparar7.executeUpdate();

            int ndiez = cajero.get(10000);
            int nveinte = cajero.get(20000);
            int ncincuenta = cajero.get(50000);
            int ncien = cajero.get(100000);

            query = "UPDATE cajeros SET ndiez=" + ndiez + ", nveinte=" + nveinte + ", ncincuenta=" + ncincuenta + ", ncien=" + ncien + ", estado=0 WHERE id=" + idcajero + ";";
            PreparedStatement preparar8 = con.prepareStatement(query);
            preparar8.executeUpdate();

            return 1;

        } catch (SQLException ex) {
            System.out.println("Error en el SQL.");
            return 0;
        }
    }
}
