package modelo;

public class CCajeros {
    
    int id;
    int ndiez;
    int nveinte;
    int ncincuenta;
    int ncien;
    int estado;

    public CCajeros() {
    }

    public CCajeros(int id, int ndiez, int nveinte, int ncincuenta, int ncien, int estado) {
        this.id = id;
        this.ndiez = ndiez;
        this.nveinte = nveinte;
        this.ncincuenta = ncincuenta;
        this.ncien = ncien;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getNdiez() {
        return ndiez;
    }

    public int getNveinte() {
        return nveinte;
    }

    public int getNcincuenta() {
        return ncincuenta;
    }

    public int getNcien() {
        return ncien;
    }

    public int getEstado() {
        return estado;
    }
    
    
}
