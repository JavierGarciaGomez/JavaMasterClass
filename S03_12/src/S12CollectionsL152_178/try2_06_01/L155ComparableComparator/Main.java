package S12CollectionsL152_178.try2_06_01.L155ComparableComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Theatre peonContreras = new Theatre("Peon Contreras", 5, 5);
        peonContreras.printSeats();
        // Sorting with a comparator
        Collections.sort((ArrayList)peonContreras.getSeats(), Theatre.PRICE_ORDER);
        peonContreras.printSeats();




    }

}
