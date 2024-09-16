package Parcial;

public class Vuelo {
    private final String trayecto;
    private String horario;
    private final int capacidad;
    private int capacidadDisponible;

    public Vuelo(String trayecto, String horario, int capacidad) {
        this.trayecto = trayecto;
        this.horario = horario;
        this.capacidad = capacidad;
    }

    public String getTrayecto(){
        return trayecto;
    }
    public String toString(){
        return String.format("%s %s %s", trayecto, horario, capacidadDisponible);
    }
}
