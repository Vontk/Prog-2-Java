package Parcial;

public class Reserva {
    final Vuelo vuelo;
    final Pasajero pasajero;
    public Reserva(Vuelo vuelo, Pasajero pasajero){
        this.vuelo = vuelo;
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }
}
