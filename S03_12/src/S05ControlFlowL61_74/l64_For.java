package S05ControlFlowL61_74;

public class l64_For {
    public static void main(String[] args) {
        /*64. For*/
        int amount = 10000;
        for (int i = 1; i <= 10; i++) {
            System.out.println(amount + " at " + i + "% interest = " + String.format("%.2f", calculateInterest(amount, i)));
        }

        /* 66. Ejercicio Sum odd*/
        System.out.println(sumOdd(1,100));
        System.out.println(sumOdd(-1,100));
        System.out.println(sumOdd(100,100));
        System.out.println(sumOdd(13,13));
        System.out.println(sumOdd(100,-100));
        System.out.println(sumOdd(100,1000));
    }

    /*64. For*/
    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    /* 66. Ejercicio Sum Odd*/
    public static boolean isOdd(int number) {
        if (number > 0 && number % 2 != 0) {
            return true;
        } else return false;
    }

    public static int sumOdd(int start, int end) {
        if (end < start || start < 0) {
            return -1;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum = sum + i;
            }
        }
        return sum;
    }

}