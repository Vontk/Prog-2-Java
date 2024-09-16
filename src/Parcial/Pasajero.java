package Parcial;

public class Pasajero {

    private final String numero;
    private final int dni;

    public Pasajero(String numero, int dni){
        this.numero = numero;
        this.dni = dni;
    }
    public int getDni() {
        return dni;
    }
}
