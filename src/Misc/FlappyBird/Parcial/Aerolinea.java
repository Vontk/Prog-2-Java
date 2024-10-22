package Parcial;

import java.util.ArrayList;

public class Aerolinea {

    private String defecto;

    {
        defecto = "valor por defect";
    }

    private ArrayList<Vuelo> vuelos;
    private ArrayList<Pasajero> pasajeros;
    private ArrayList<Reserva> reservas;

    public Aerolinea(){
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();
        this.vuelos = vuelos;
        this.pasajeros = pasajeros;
        this.reservas = reservas;
    }
    public String getDefecto(){
        return defecto;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
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
        if (vuelo.getCapacidadDisponible() <= 0 ){
            return;
        }
        vuelo.setCapacidadDisponible(vuelo.getCapacidadDisponible() -1);
        reservas.add(new Reserva(vuelo, pasajero));
    }
    public void cancelReserva(Reserva reserva){
        if (reservas.contains(reserva)){
            reservas.remove(reserva);
            Vuelo vuelo = reserva.getVuelo();
            vuelo.setCapacidadDisponible(vuelo.getCapacidadDisponible() +1);
        }
    }
}
