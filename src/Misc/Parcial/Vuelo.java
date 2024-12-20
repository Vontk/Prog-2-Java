package Misc.Parcial;

public class Vuelo {
    private final String trayecto;
    private String horario;
    private final int capacidad;
    private int capacidadDisponible;

    public Vuelo(String trayecto, String horario, int capacidad) {
        this.trayecto = trayecto;
        this.horario = horario;
        this.capacidad = capacidad;
        this.capacidadDisponible = capacidad;
    }

    public String getTrayecto(){
        return trayecto;
    }
    public String getHorario(){
        return horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCapacidadDisponible(){
        return capacidadDisponible;
    }

    public void setCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }

    public String toString(){
        return String.format("%s %s %s", trayecto, horario, capacidadDisponible);
    }

    public boolean equals(Vuelo vuelo){
        if (vuelo.getTrayecto().equals(trayecto)){
            if (vuelo.getHorario().equals(horario)){
                if (vuelo.getCapacidad() == capacidad){
                    return true;
                }
            }
        }
        return false;
    }
}
