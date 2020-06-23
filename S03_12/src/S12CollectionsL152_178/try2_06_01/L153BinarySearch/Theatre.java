package S12CollectionsL152_178.try2_06_01.L153BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {
    private final String theatreName;
    // 153 Change Collection to a List
    // Changing to Lists, HashSet, LinkedHashSet, SortSet.
    private List<Seat> seats  = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        System.out.println("Creating a theater "+ theatreName+" with "+numRows*seatsPerRow+" seats");
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

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.print(seat.getSeatNumber()+" ");
        }
    }


    public boolean reserveSeat(String seatNumber) {
        System.out.println("\nReserve seat method");
        Seat requestedSeat = new Seat(seatNumber);
        /* 153: Binary Search: for this to work the list must be previously sorted ascending
        it returns the index of the search key, if it is contained
        * */
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        System.out.println("Found seat in the collection: "+foundSeat+". Requested seat number: "+requestedSeat.getSeatNumber());
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        } else{
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
    }

    // 153: Implementing Comparable
    private class Seat implements Comparable<Seat> {
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

        // 153: Compare to method
        @Override
        public int compareTo(Seat seat) {
            //System.out.println("Comparing seat "+this.getSeatNumber()+" with seat "+seat.getSeatNumber());
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}