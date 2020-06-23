package S12CollectionsL152_178.try1_05_30.L157_159AdventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        // Split method:
        System.out.println("You are standing at the end of a road before a small brick building");

        System.out.println("==================================");
        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        // ADDING EXITS
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        locations.get(2).addExit("N", 5);
        locations.get(3).addExit("W", 1);
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

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
