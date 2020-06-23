package S08ArraysListsBoxingL98_121.l111_114AutoboxingUnboxing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        * 111
        */
        String[] strArrayList = new String[10];
        int[] intArray=new int[10];
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Tim");

        // But We can't create an Arraylist of primitive types:
        // ArrayList<int> arrayList;
        // But We can create for example an IntClass
        class IntClass{
            private int anInt;
            public IntClass(int anInt) {
                this.anInt = anInt;
            }
            public int getAnInt() {
                return anInt;
            }
            public void setAnInt(int anInt) {
                this.anInt = anInt;
            }
        }

        // But this is not a good idea, is better to use Autoboxing, that is kind of similar.
        Integer integer = new Integer(54);
        integer = (54);
        Double doubleValue = 43.22;

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(34);
        integerArrayList.add(25);
        integerArrayList.add(54);

        ArrayList<IntClass> intClasses = new ArrayList<>();
        intClasses.add(new IntClass(4));


        /* These things are possible*/
        Integer myIntValue = 56;
        System.out.println(myIntValue);
        myIntValue = Integer.valueOf(56);
        System.out.println(myIntValue);
        int myInt = myIntValue; // Java is actually doing this: int myInt = myIntValue.intValue();
        System.out.println(myInt);

        /* This was boxing and autoboxing, that is happening something behind*/

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(Double.valueOf(dbl)); // This is autoboxing: convert from a primitive to a wrapper class
            myDoubleValues.add(dbl); // shortway
        }


        for (double dbl : myDoubleValues) {
            System.out.println(Double.valueOf(dbl));  // This is unboxing: convert from a wrapper class to a primirive
            System.out.println(dbl); // shortway
        }

        /* 112. Challenge */
        // You job is to create a simple banking application.
        // There should be a Bank class
        // It should have an arraylist of Branches
        // Each Branch should have an arraylist of Customers
        // The Customer class should have an arraylist of Doubles (transactions)
        // Customer:
        // Name, and the ArrayList of doubles.
        // Branch:
        // Need to be able to add a new customer and initial transaction amount.
        // Also needs to add additional transactions for that customer/branch
        // Bank:
        // Add a new branch
        // Add a customer to that branch with initial transaction
        // Add a transaction for an existing customer for that branch
        // Show a list of customers for a particular branch and optionally a list
        // of their transactions
        // Demonstration autoboxing and unboxing in your code
        // Hint: Transactions
        // Add data validation.
        // e.g. check if exists, or does not exist, etc.
        // Think about where you are adding the code to perform certain actions

        Bank bank = new Bank("MiBanco");

        bank.addBranch("norte");
        bank.addBranch("sur");
        bank.addCustomer("norte", "Pedro", 1000);
        bank.addCustomer("norte", "Mark", 10000.25);
        bank.addCustomer("norte", "Percy", 220.12);

        bank.addCustomer("sur", "Bob", 150.54);

        bank.addCustomerTransaction("norte", "Pedro", 300);
        bank.addCustomerTransaction("norte", "Pedro", 300);
        bank.addCustomerTransaction("norte", "Pedro", 300);

        bank.listCustomers("norte", false);
        bank.listCustomers("norte", true);
    }
}
