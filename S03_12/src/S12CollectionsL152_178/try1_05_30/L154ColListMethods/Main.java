package S12CollectionsL152_178.try1_05_30.L154ColListMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* 153. BinarySearch
         * Binary search makes searches more efficient in an ordered list: because it divides every search in two parts, instead of searching each element
         * For example if the number is 23 in a list of 100, it checks if is < or > of 50; then if is < or > of 25, then if is < or > of 12
         * then if is < or > of 19, the 22 and found. So it makes 5 comparisons instead of 100
         * */

        Theatre PeonContreras = new Theatre("Peon Contreras", 8, 5);
        System.out.println("Printing a shallow copy");
        List<Theatre.Seat> seatCopy = new ArrayList<>(PeonContreras.seats);
        printList(seatCopy);

        /* Even that we instantiate a new arraylist, is receiving the same parameter so if
        We reserve one seat of the shallow copy, We are also reserving the seat of the
        original list
         */
        seatCopy.get(1).reserve();
        PeonContreras.reserveSeat("A02");

        System.out.println("Reversing the seat order");
        Collections.reverse(seatCopy);
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(PeonContreras.seats);
        System.out.println("Printing a shuffle copy");
        Collections.shuffle(seatCopy);
        printList(seatCopy);
        seatCopy.get(1).reserve(); // The reservation is now of the new order

        //Collections methods:
        //reverse
        //shuffle
        //min and max
        System.out.println("\nMAX: " + Collections.max(seatCopy).getSeatNumber() + " MIN: " + Collections.min(seatCopy).getSeatNumber());

        sortList(seatCopy);
        System.out.println("Sorting again the list");
        printList(seatCopy);

        // Swap same method in main
        System.out.println("Printing seat copy");
        for (int i=0; i<seatCopy.size()-1; i++){
            for(int j=i+1; j<seatCopy.size(); j++){
                if(seatCopy.get(i).compareTo(seatCopy.get(j))>0){
                    Collections.swap(seatCopy, i, j);
                }
            }
        }
        printList(seatCopy);

        // COPY METHOD: IS NOT A SHALLOW COPY; IS ANOTHER REFERENCE




    }

    public static void printList(List<Theatre.Seat> list) {
        System.out.println("PRINTING THE LIST");
        int counter = 0;
        for (Theatre.Seat s : list) {
            counter++;
            System.out.print(s.getSeatNumber() + " ");
            if (counter % 10 == 0) {
                System.out.println();
            }
        }
    }

    // Sorting and swapping method
    public static void sortList(List<? extends Theatre.Seat> list){
        // for each element of the list
        for (int i=0; i<list.size()-1; i++){
            // for the second element
            for(int j=i+1; j<list.size(); j++){
                // if the element is >0 then swap
                if(list.get(i).compareTo(list.get(j))>0){
                    Collections.swap(list, i, j);
                    System.out.printf("\nSwapping %s for %s", list.get(i).getSeatNumber(), list.get(j).getSeatNumber());
                }
                else System.out.println("not swapping");
            }
        }
    }
}
