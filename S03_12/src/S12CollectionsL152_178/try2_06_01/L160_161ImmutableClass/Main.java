package S12CollectionsL152_178.try2_06_01.L160_161ImmutableClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        /* A Strategy for Defining Immutable Objects
        1 Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
        2 Make all fields final and private.
        3 Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
        4 If the instance fields include references to mutable objects, don't allow those objects to be changed:
            Don't provide methods that modify the mutable objects.
            Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
        * */

        /*
        * 161. Challenge: what is wrong with the Location class that allows the program to compile, but crash in the runtime:
        * Solution the problem is that the program will crash if you add a location without exits, so a correction is made
        * */
        // location without exits
        locations.put(10, new Location(0,"You are sitting in front of a computer learning Java",null));


        Scanner scanner = new Scanner(System.in);
        // temp instantiation to put the exits in each location
        Map<String, Integer> tempExits = new HashMap<>();
        locations.put(0, new Location(0,"You are sitting in front of a computer learning Java",tempExits));

        tempExits.put("W",2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));
        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));
        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));
        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));
        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExits));





        // ADDING EXITS

        // ChALLENGE
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        // Logic of the game
        int loc = 1;
        while (true) {
            // Print the current location
            System.out.println(locations.get(loc).getDescription());
            // Exit of the game
            if (loc == 0) {
                break;
            }

            // Hasmap copy with exits of the location
            Map<String, Integer> exits = locations.get(loc).getExits();
            // Printing the exits
            System.out.println("Available exits are: ");
            for(String exit: exits.keySet()){
                System.out.print(exit+ ", ");
            }
            System.out.println("\nInput the next exit");
            // Input the next exit
            String direction=scanner.nextLine().toUpperCase();

            // Challenge changes
            // If is longer than one is not a singlecharacter command so we check the word, if not it ignores it
            if(direction.length() > 1) {
                // We split the string in words
                String[] words = direction.split(" ");
                // for each word we check if is in the vocabulary and move there
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        // this returns the value of the key used as a parameter, so for North it will return N, and so on.
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            // Moving
            if (exits.containsKey(direction)){
                loc=exits.get(direction);
            }
            else{
                System.out.println("You cannot go to that direction");
            }
        }
    }
}
