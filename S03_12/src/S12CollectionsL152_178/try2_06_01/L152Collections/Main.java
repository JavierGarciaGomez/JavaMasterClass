package S12CollectionsL152_178.try2_06_01.L152Collections;

public class Main {
    public static void main(String[] args) {
        /* 152. Collections Overview
        * Collections is the framework of all the collections kind
        * */

        Theatre peonContreras = new Theatre("Peon Contreras", 10, 25);
        peonContreras.getSeats();
        peonContreras.reserveSeat("G12");
        peonContreras.reserveSeat("G13");
        peonContreras.reserveSeat("G12");
        peonContreras.cancelReservation("G12");
        peonContreras.cancelReservation("Z12");
        peonContreras.reserveSeat("G12");

    }
}
