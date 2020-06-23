package S12CollectionsL152_178.try1_05_30.L153BinarySearch;

import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class Theatre {
    private final String theatreName;
    // Change List to a Collection
    private List<Seat> seats  = new ArrayList<>();

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
        System.out.println("\nReserve seat method");
        Seat requestedSeat = new Seat(seatNumber);
        // Binary Search
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        System.out.println("Found seat in the collection: "+foundSeat+". Requested seat number: "+requestedSeat.getSeatNumber());
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        } else{
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
    }

    // for testing
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.print(seat.getSeatNumber()+" ");
        }
    }

    // Comparable
    private class Seat implements Comparable<Seat> {
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

        // BINARY SEARCH
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}