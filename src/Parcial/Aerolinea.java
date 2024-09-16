package Parcial;

import java.util.ArrayList;

public class Aerolinea {

    private ArrayList<Vuelo> vuelos;
    private ArrayList<Pasajero> pasajeros;
    private ArrayList<Reserva> reservas;

    public Aerolinea(){
    }

    public void listarVuelos(String trayecto){
        for (int i = 0; i < vuelos.size(); i++){
            if (vuelos.get(i).getTrayecto().equals(trayecto)){
                System.out.println(vuelos.get(i).toString());
            }
        }
    }

    public void addPasajero(String numero, int dni){
        for (int i = 0; i < pasajeros.size(); i++){
            if (pasajeros.get(i).getDni() == dni){
                return;
            }
        }
        pasajeros.add(new Pasajero(numero, dni));
    }
    public void addVuelo(String trayecto,String horario, int capacidad){
        Vuelo new_vuelo = new Vuelo(trayecto, horario, capacidad);
        for (int i = 0; i < vuelos.size(); i++){
            Vuelo vuelo = vuelos.get(i);
            if (vuelo.equals(new_vuelo)){
                new_vuelo = null;
                return;
            }
        }
        vuelos.add(new_vuelo);
    }
    public void addReserva(Vuelo vuelo, Pasajero pasajero){
        if (vuelo.getCapacidad() == vuelo.getCapacidadDisponible()){
            return;
        }
        reservas.add(new Reserva(vuelo, pasajero));
    }

}
