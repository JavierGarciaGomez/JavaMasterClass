package L225;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = 98;
        int y = 0;
        // LBYL Loop before you leave
        System.out.println(divideLBYL(x, y));
        // EAFP Easy to ask for forgiveness
        System.out.println(divideEAFP(x, y));
        //System.out.println(divide(x, y));

        int z = getInt();
        z=getIntLBYL();
        System.out.println(z);
    }

    // Catching an error with an if
    private static int divideLBYL(int x, int y) {
        if(y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    // Catching an error with a Try Catch
    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }

    // Not catching any error
    private static int divide(int x, int y) {
        return x / y;
    }

    // Error with Scanner
    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    // Scanner with if
    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = s.next();
        for(int i=0; i<input.length(); i++) {
            // if a character is not a digit then break
            if(Character.isDigit(input.charAt(i))) {
                System.out.println("Found a digit");
                isValid = true;
            } else{
                System.out.println("Found a character that is not a digit");
                isValid=false;
                break;
            }
        }
        if(isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        try {
            return s.nextInt();
        } catch(InputMismatchException e) {
            return 0;
        }
    }

}
