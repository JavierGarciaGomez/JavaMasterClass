package S12CollectionsL152_178.try1_05_30.L155_156ComparableComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre PeonContreras = new Theatre("Peon Contreras", 8, 12);
        printList((List)PeonContreras.getSeats());
        PeonContreras.reserveSeat("D12");
        PeonContreras.reserveSeat("B13");

        List<Theatre.Seat> reverseSeats = new ArrayList<>(PeonContreras.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        // Priceseats with the compare
        List<Theatre.Seat> priceSeats = new ArrayList<>(PeonContreras.getSeats());
        priceSeats.add(PeonContreras.new Seat("B00", 13.00));
        priceSeats.add(PeonContreras.new Seat("A00", 13.00));
        // SORTING WITH THE STATIC METHOD PRICE ORDER
        System.out.println("SORTING WITH STATIC METHOD COMPARE: ordered by price");
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);

        printList(priceSeats);

    }

    public static void printList(List<Theatre.Seat> list) {
        int counter = 0;
        for (Theatre.Seat s : list) {
            counter++;
            System.out.print(s.getSeatNumber() + " "+ s.getPrice()+" ");
            if (counter % 12 == 0) {
                System.out.println();
            }
        }
    }
}
