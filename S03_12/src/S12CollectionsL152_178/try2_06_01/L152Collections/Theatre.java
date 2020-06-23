package S12CollectionsL152_178.try2_06_01.L152Collections;

import java.util.ArrayList;
import java.util.Collection;

public class Theatre {
    private final String theatreName;
    private Collection<Seat> seats  = new ArrayList<>();

    // CONSTRUCTOR
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        System.out.println("Creating a theater "+ theatreName+" with "+numRows*seatsPerRow+" seats");
        this.theatreName = theatreName;

        // lastrow is A (65) + numrows
        int lastRow = 'A' + (numRows - 1);

        // Adding seats in the theater
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
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.print(seat.getSeatNumber()+" ");
        }
        System.out.println();
    }


    //Reserve Seat
    // MYCHANGE: Changed from boolean to void
    public void reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
        // Check if the seat exists, if so, then assign true.
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }
        // If the seat is found then try to reserve. If not, then return false
        if (requestedSeat != null) {
            requestedSeat.reserve();}
        else{
            System.out.println("There is no seat " + seatNumber);
        }
    }

    //Cancel Seat
    public void cancelReservation(String seatNumber) {
        Seat requestedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        if (requestedSeat != null) {
            requestedSeat.cancel();
        } else{
            System.out.println("There is no seat " + seatNumber);
        }
    }

    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if (this.reserved) {
                System.out.println("Seat " + seatNumber + " is ALREADY reserved, please try again");
                return false;
            } else {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
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
