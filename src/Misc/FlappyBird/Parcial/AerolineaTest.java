package Parcial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AerolineaTest {

    private Aerolinea aerolinea;

    @BeforeEach
    public void setUp() {
        aerolinea = new Aerolinea();
        aerolinea.addVuelo("NYC-MAD", "10:00", 100);
        aerolinea.addVuelo("LAX-TYO", "12:00", 50);
        aerolinea.addPasajero("123", 456789);
        aerolinea.addPasajero("456", 987654);
    }

    @Test
    public void testAddPasajero() {
        assertEquals(2, aerolinea.getPasajeros().size());
        aerolinea.addPasajero("789", 123456);
        assertEquals(3, aerolinea.getPasajeros().size());

        // Trying to add a duplicate passenger (should not be added)
        aerolinea.addPasajero("123", 456789);
        assertEquals(3, aerolinea.getPasajeros().size());
    }

    @Test
    public void testAddVuelo() {
        // Already added flights in setUp()
        assertEquals(2, aerolinea.getVuelos().size());

        // Adding a new flight
        aerolinea.addVuelo("BUE-SCL", "14:00", 150);
        assertEquals(3, aerolinea.getVuelos().size());

        // Trying to add a duplicate flight (should not be added)
        aerolinea.addVuelo("NYC-MAD", "10:00", 100);
        assertEquals(3, aerolinea.getVuelos().size());
    }

    @Test
    public void testAddReserva() {
        Vuelo vuelo = aerolinea.getVuelos().get(0); // "NYC-MAD" flight
        Pasajero pasajero = aerolinea.getPasajeros().get(0); // Passenger "123"

        // Adding a reservation
        aerolinea.addReserva(vuelo, pasajero);
        assertEquals(1, aerolinea.getReservas().size());
        assertEquals(99, vuelo.getCapacidadDisponible());

        // Adding another reservation for the same flight
        aerolinea.addReserva(vuelo, aerolinea.getPasajeros().get(1)); // Passenger "456"
        assertEquals(2, aerolinea.getReservas().size());
        assertEquals(98, vuelo.getCapacidadDisponible());
    }

    @Test
    public void testCancelReserva() {
        Vuelo vuelo = aerolinea.getVuelos().get(0); // "NYC-MAD" flight
        Pasajero pasajero = aerolinea.getPasajeros().get(0); // Passenger "123"

        // Add a reservation
        aerolinea.addReserva(vuelo, pasajero);
        Reserva reserva = aerolinea.getReservas().get(0);

        // Cancel the reservation
        aerolinea.cancelReserva(reserva);
        assertEquals(0, aerolinea.getReservas().size());
        assertEquals(100, vuelo.getCapacidadDisponible());
    }

    @Test
    public void testListarVuelos() {
        // Assuming we have a way to capture system output
        aerolinea.listarVuelos("NYC-MAD");
        // Check if only the "NYC-MAD" flight is listed in the output

        aerolinea.listarVuelos("LAX-TYO");
        // Check if only the "LAX-TYO" flight is listed in the output
    }
}
