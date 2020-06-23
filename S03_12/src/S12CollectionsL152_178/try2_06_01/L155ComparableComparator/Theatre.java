package S12CollectionsL152_178.try2_06_01.L155ComparableComparator;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats  = new ArrayList<>();

    // 155. Comparator
    public static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat o1, Seat o2) {
            /*This method has a problem, because it takes as the same object when they have the same price, when They aren't
            * and it can bring problems with sets and ordered lists*/
            System.out.println("Comparing "+o1.getSeatNumber()+"$"+o1.getPrice()+"with "+o2.getSeatNumber()+"$"+o2.getPrice());
            if(o1.getPrice()>o2.getPrice()) return 1;
            else if(o1.getPrice()==o2.getPrice()) return 0;
            else return -1;
        }
    };

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        System.out.println("Creating a theater "+ theatreName+" with "+numRows*seatsPerRow+" seats");
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);

        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price=(lastRow-row)*3 +seatsPerRow-Math.abs(((seatsPerRow/2)-(seatNum-1)));
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public Collection<Seat> getSeats(){
        return seats;
    }

    public void printSeats(){
        for(Seat s:seats){
            System.out.print(s.getSeatNumber()+" $"+s.getPrice()+", ");
        }
        System.out.println();
    }

    public boolean reserveSeat(String seatNumber) {
        System.out.println("\nReserve seat method");
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        System.out.println("Found seat in the collection: "+foundSeat+". Requested seat number: "+requestedSeat.getSeatNumber());
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        } else{
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber, double price) {
            // System.out.println("Creating a seat with "+seatNumber+" and price:"+price);
            this.seatNumber = seatNumber;
            this.price=price;
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

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}