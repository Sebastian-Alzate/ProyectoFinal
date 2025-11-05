package modelo;

public class CClientes {
    
    int id;
    String nombre;
    String apellido;
    String telefono;
    String ciudad;
    int ncuenta;
    double saldo;
    int estado;

    public CClientes() {
    }

    public CClientes(int id, String nombre, String apellido, String telefono, String ciudad, int ncuenta, double saldo, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.ncuenta = ncuenta;
        this.saldo = saldo;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getNcuenta() {
        return ncuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getEstado() {
        return estado;
    }
    
    
}
