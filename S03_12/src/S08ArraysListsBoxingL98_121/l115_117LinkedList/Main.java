package S08ArraysListsBoxingL98_121.l115_117LinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 116.
        List<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        printList(placesToVisit);
        System.out.println("Adding a new place: index 1 and removing 4");
        placesToVisit.add(1, "Alice Springs");
        placesToVisit.remove(4);
        printList(placesToVisit);

        List<String> placesToVisit2 = new ArrayList<String>();
        placesToVisit2.add("Sydney");
        placesToVisit2.add("Melbourne");
        placesToVisit2.add("Brisbane");
        placesToVisit2.add(2, "Alice Springs");

        printList(placesToVisit2);

        /* Advantages of a linkedlist
         * For example an order*/
        //117
        System.out.println("**********118 ********************");
        LinkedList<String> placesToVisit3 = new LinkedList<>(); 
        
        addInOrder(placesToVisit3, "Sydney");
        addInOrder(placesToVisit3, "Melbourne");
        addInOrder(placesToVisit3, "Brisbane");
        addInOrder(placesToVisit3, "Perth");
        addInOrder(placesToVisit3, "Canberra");

        addInOrder(placesToVisit3, "Alice Springs");
        System.out.println("A imprimir");
        printList(placesToVisit3);

        /* Menu*/
        visit(placesToVisit3);
        



    }

    private static void printList(List<String> placesToVisit) {
        System.out.println("\n PRINTING THE LIST OF PLACES TO VISIT");
        /* Iterator */
        Iterator<String> iterator = placesToVisit.iterator();
        while (iterator.hasNext()) {
            System.out.println("Now visiting " + iterator.next());
        }
        System.out.println("================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity); // this gives us a number: (0 ara equals;
            if (comparison == 0) { // Equal so not add
                System.out.println("This city is already in the list");
                return false;
            } else if (comparison > 0) { // In this case the value is minor
                stringListIterator.previous(); // have to go back because the iterator has moved
                stringListIterator.add(newCity);
                return true;

            } else {
                // In this case the value is major
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;

                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;

            }

        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }


}
