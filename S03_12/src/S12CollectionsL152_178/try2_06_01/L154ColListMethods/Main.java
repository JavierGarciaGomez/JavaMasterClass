package S12CollectionsL152_178.try2_06_01.L154ColListMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre peonContreras = new Theatre("Peon Contreras", 10, 10);
        peonContreras.getSeats();
        // 154
        System.out.println("*******154 **************");
        /* In a shallow copy, even if They are separate lists they share the same references:
        as it can be see with the next example that makes a valid reservation for both lists.
        * */
        List<Theatre.Seat> shallowCopy = new ArrayList<>(peonContreras.seats); // shallow copy
        shallowCopy.get(1).reserve();
        peonContreras.reserveSeat("A02");

        // Reverse, shuffle, swap, min max, copy
        printSeatsList(peonContreras.seats);
        Collections.reverse(shallowCopy); // But there are separate lists as We can see in the next example:
        printSeatsList(shallowCopy);
        printSeatsList(peonContreras.seats);
        Collections.shuffle(shallowCopy); // Shuffle method
        printSeatsList(shallowCopy);
        Collections.swap(shallowCopy, 0, 1);
        printSeatsList(shallowCopy);
        System.out.println("min() "+ Collections.min(shallowCopy).getSeatNumber()+". max()"+ Collections.max(shallowCopy).getSeatNumber());
        sortWithSwap(shallowCopy);
        printSeatsList(shallowCopy);
        List<Theatre.Seat> newList = new ArrayList<>(peonContreras.seats.size());
        // Collections.copy(newList, peonContreras.seats);

    }
    public static void printSeatsList(List<Theatre.Seat> list){
        for(Theatre.Seat s:list){
            System.out.print(s.getSeatNumber()+" ");
        }
        System.out.println();
    }

    public static void sortWithSwap(List<? extends Theatre.Seat> list){
        for (int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size();j++){
                if(list.get(i).compareTo(list.get(j))>0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }

}
