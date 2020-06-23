package S08ArraysListsBoxingL98_121.l98_103Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* 98. Arrays*/
        System.out.println("\n ************* 98********************");
        int[] myIntArray = new int[7];
        int[] myArray2 = {1, 2, 3};
        myIntArray[2] = 12;
        // int[] ints = getIntegers(5);
        int[] ints = {2,6,4};
        printArray(ints);
        System.out.printf("Get average: "+getAverage(ints));

        /* 99. Challenge */
        System.out.println("\n\n ************* 99********************");
        // Create a program using arrays that sorts a list of integers in descending order.
        // Descending order is highest value to lowest.
        // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
        // ultimately have an array with 106,81,26, 15, 5 in it.
        // Set up the program so that the numbers to sort are read in from the keyboard.
        // Implement the following methods - getIntegers, printArray, and sortIntegers
        // getIntegers returns an array of entered integers from keyboard
        // printArray prints out the contents of the array
        // and sortIntegers should sort the array and return a new array containing the sorted numbers
        // you will have to figure out how to copy the array elements from the passed array into a new
        // array and sort them and return the new sorted array.

        int[] myIntegers = new int[5];
        myIntegers=ints;
        printArray(myIntegers);
        myIntegers = sortArray(myIntegers);
        printArray(myIntegers);

        /* 101 References vs value types */
        System.out.println("\n\n ************* 101********************");

        int myIntValue = 10;
        int anotherValue = myIntValue;
        anotherValue++;

        System.out.println("myIntValue = "+myIntValue);
        System.out.println("anotherValue = "+anotherValue);

        /*Even that it seems that anothervalue is equal to myintvalue, there are two different variables,
        this is differente when We use objects, because this are used by reference
        the reference holds an address to the object, but not the object itself:
         */
        int[] myIntArray1 = new int[3];
        int[] myIntArray2 = myIntArray1;

        System.out.println(Arrays.toString(myIntArray1));
        System.out.println(Arrays.toString(myIntArray2));
        myIntArray1[0] = 4;
        System.out.println("After changing a value");
        System.out.println(Arrays.toString(myIntArray1));
        System.out.println(Arrays.toString(myIntArray2));

        System.out.println("After changing it with a method");
        modifyArray(myIntArray2);
        System.out.println(Arrays.toString(myIntArray1));
        System.out.println(Arrays.toString(myIntArray2));

        /* Los valores se cambian en ambos arrays, porque ambas variables hacen referencia al mismo array de la memoria,
        Por lo que  es una copia del mismo valor en la moemoria
        Lo mismo ocurre cuando pasa a un método, es otra referencia del mismo valor en la memoria
        Si se vuelve a inicializar entonces se crea otro array
        */

        // DeReferencing

        myIntArray2 = new int[]{1, 3};
        System.out.println("Derreferencing");
        System.out.println(Arrays.toString(myIntArray1));
        System.out.println(Arrays.toString(myIntArray2));
        System.out.println("Derreferencing with a method");
        myIntArray1=myIntArray2;
        dereferenceArray(myIntArray2);
        System.out.println(Arrays.toString(myIntArray1));
        System.out.println(Arrays.toString(myIntArray2));


        /* 102. Minimun Element challenge
        * -Write a method called readIntegers() with a parameter called count that represents how many integers the user needs to enter.
            -The method needs to read from the console until all the numbers are entered, and then return an array containing the numbers entered.
            -Write a method findMin() with the array as a parameter. The method needs to return the minimum value in the array.
            -In the main() method read the count from the console and call the method readIntegers() with the count parameter.
            -Then call the findMin() method passing the array returned from the call to the readIntegers() method.
            -Finally, print the minimum element in the array.
            Tips:
                -Assume that the user will only enter numbers, never letters
                -For simplicity, create a Scanner as a static field to help with data input
                -Create a new console project with the name eMinElementChallengef
        * */
        System.out.println("\n\n ************* 102 Challenge********************");

        System.out.println("Enter count:");
        //int count = scanner.nextInt();
        int count=4;
        //scanner.nextLine();

        //int[] returnedArray = readIntegers(count);
        int[] returnedArray = {5,2,9,1};
        int returnedMin = findMin(returnedArray);

        System.out.println("min = " + returnedMin);

        /* 103. Reverse Array Challenge */
        System.out.println("\n\n ************* 103 Reverse challenge********************");
        int[] ints2 = {1,2,3,4};
        reverse(ints2);

        printArray(ints2);



    }



    public static int[] getIntegers(int limit) {
        Scanner scanner = new Scanner(System.in);
        int[] myIntegers = new int[limit];
        for (int i = 0; i < myIntegers.length; i++) {
            System.out.println("Introduce el " + (i + 1) + "º número de " + limit);
            myIntegers[i] = scanner.nextInt();
        }
        return myIntegers;
    }

    public static double getAverage(int[] array){
        double resultado=0;
        for(int i=0; i<array.length; i++){
            resultado+=array[i];
        }
        resultado=resultado/array.length;
        return resultado;
    }

    public static void printArray(int[] array) {
        System.out.println("\n Imprimiendo array");
        for (int i = 0; i < array.length; i++) {
            System.out.println("El número del array es: " + array[i]);
        }
    }

    public static int[] sortArray(int[] array) {
        System.out.println("\n ordenando array");
        int numaux;
        for (int i = 0; i < array.length; i++) {
            numaux = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[i] < array[j]) {
                    array[i] = array[j];
                    array[j] = numaux;
                }
            }
        }

        return array;
    }

    //101.
    public static void modifyArray(int[] array){
        array[1]=2;
    }

    public static void dereferenceArray(int[] array){
        array = new int[] {9,9,9};
    }


    // 102. Challenge
    private static int[] readIntegers(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a number:");
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number;
        }
        return array;

    }

    private static int findMin(int[] array) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            int value = array[i];

            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    // 103
    private static void reverse(int[] ints2) {
        int maxIndex = ints2.length-1;
        int halfLength = ints2.length / 2;

        for(int i=0; i<halfLength; i++){
            int temp = ints2[i];
            ints2[i]=ints2[maxIndex-i];
            ints2[maxIndex-i] =temp;
        }
    }

}

