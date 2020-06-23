package S12CollectionsL152_178.try1_05_30.L152Collections;

import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class Theatre {
    private final String theatreName;
    private Collection<Seat> seats  = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        // lastrow is A (65) + numrows
        int lastRow = 'A' + (numRows - 1);

        // first for for the rows; second for the seats
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                // Instantiate the inner class that receives a String: A letter and a number with two digits..
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                // The seats are added in an arraylist
                seats.add(seat);
            }
        }
    }

    // Getter
    public String getTheatreName() {
        return theatreName;
    }

    //Reserve Seat
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
        // Asigna el asiento a la variable requerida
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        // Si no existe, no lo asigna a la variable
        if (requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        // si existe el asiento llama al método reservar para ver si está disponible
        return requestedSeat.reserve();
    }

    //Reserve Seat
    public boolean cancelSeat(String seatNumber) {
        Seat requestedSeat = null;
        // Asigna la variable
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        // Si no existe, no lo asigna a la variable
        if (requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        // si existe el asiento llama al método reservar para ver si está disponible
        return requestedSeat.cancel();
    }

    // for testing
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.print(seat.getSeatNumber()+" ");
        }
        System.out.println();
    }

    private class Seat {
        // Se vuelve constante cuando se inicialice
        private final String seatNumber;
        // Variable para determinar si el asiento está reservado
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        // Verifica si ya está o no reservado, en caso de que no lo reserva e imprime
        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is ALREADY reserved, please try again");
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                System.out.println("We cant cancel" + seatNumber+ "because is not reserved");
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }


}
