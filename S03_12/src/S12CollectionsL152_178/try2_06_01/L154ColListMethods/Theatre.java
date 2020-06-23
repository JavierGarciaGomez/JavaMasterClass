package S12CollectionsL152_178.try2_06_01.L154ColListMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {
    private final String theatreName;
    // 154 changing class private to public
    public List<Seat> seats  = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        System.out.println("Creating a theater "+ theatreName+" with "+numRows*seatsPerRow+" seats");
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);

        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.print(seat.getSeatNumber()+" ");
        }
    }


    public boolean reserveSeat(String seatNumber) {
        System.out.println("\nReserve seat method");
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        System.out.println("Found seat in the collection: "+foundSeat+". Requested seat number: "+requestedSeat.getSeatNumber());
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        } else{
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
    }

    // 154 changing class private to public
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

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

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}