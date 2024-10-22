package Misc.FlappyBird.Parcial;

public class Pasajero {

    private final int dni;
    private final String numero;

    public Pasajero(String numero, int dni){
        this.dni = dni;
        this.numero = numero;
    }
    public int getDni() {
        return dni;
    }
    public String getNumero() {
        return numero;
    }
}
