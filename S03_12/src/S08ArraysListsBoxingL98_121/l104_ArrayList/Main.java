package S08ArraysListsBoxingL98_121.l104_ArrayList;

import S08ArraysListsBoxingL98_121.l107_110Challenge.MobilePhone;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList;
    private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404");

    public static void main(String[] args) {
        /*104. Arraylist
         *
         * Array resize
         *
         * ArrayList implements the List interface
         * ArrayList is an resizable array
         *
         *  */

        System.out.println("\n\n*********104. ArrayList 1************");
        groceryList = new GroceryList();
        groceryList.addGroceryItem("Banana");
        groceryList.addGroceryItem("Apple");
        groceryList.addGroceryItem("Watermelon");
        groceryList.modifyGroceryItem(2, "Peach");
        groceryList.removeGroceryItem("Peach");
        groceryList.printGroceryList();

        /* 105. ArrayList 2
         * Explanation of the intervface
         * */
        System.out.println("\n\n*********105. ArrayList 1************");
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine(); // To clean the input buffer
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyGroceryItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;

                case 6:
                    processArrayList();
                    break;

                default:
                    quit = true;
                    break;

            }

        }

        System.out.println(groceryList.findItem("Apple"));

    }

    private static void printInstructions() {
        System.out.println("INSTRUCTIONS" +
                "\n0: Print Instructions" +
                "\n1: Print list" +
                "\n2: Add item" +
                "\n3: Modify item" +
                "\n4: Remove item" +
                "\n5: Search item" +
                "\n6: Process Array List" +
                "\n7: Quit" +
                "");
    }

    private static void addItem() {
        System.out.print("Introduce the item ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    private static void modifyGroceryItem() {
        System.out.println("Introduce the otem you wanna replace");
        String oldItem = scanner.nextLine();
        System.out.println("Introduce the new item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(oldItem, newItem);
    }

    private static void removeItem() {
        System.out.println("Introduce the item");
        String item = scanner.nextLine();
        groceryList.removeGroceryItem(item);
    }

    private static void searchForItem() {
        System.out.println("Introduce the item");
        String item = scanner.nextLine();
        if (groceryList.onFile(item) == true) System.out.println("The item EXISTS");
        else System.out.println("The item DOESN'T EXISTS");
    }

    private static void processArrayList() {
        // Three wats
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        String[] anArray = new String[groceryList.getGroceryList().size()];
        anArray = groceryList.getGroceryList().toArray(anArray);
    }
}
