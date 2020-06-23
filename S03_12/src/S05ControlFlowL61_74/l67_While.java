package S05ControlFlowL61_74;

public class l67_While {
    public static void main(String[] args) {
        /* 67. While
        * While
        * Do while*/
        /* 69. Ejercicios */

        System.out.println(sumFirstAndLastDigit(252));

        System.out.println(getGreatestCommonDivisor(25,15));
        System.out.println(getGreatestCommonDivisor(12,30));
        System.out.println(getGreatestCommonDivisor(9,18));
        System.out.println(getGreatestCommonDivisor(81,153));
    }

    // Exercise 16
    public static int sumFirstAndLastDigit(int number) {
        int digit1 = 0;
        int digit2 = 0;
        int sum=0;
        if (number < 0) return -1;
        while (number != 0) {
            digit1 = number % 10;
            while (number != 0) {
                digit2 = number % 10;
                number /= 10;
                continue;
            }
            sum = digit1 + digit2;
        }
        return sum;
    }

    // Exercise 20
    public static int getGreatestCommonDivisor(int first, int second){
        if(first<10||second<10){
            return -1;
        }

        for(int i=first; i>=1; i--){
            if(first%i==0){
                if(second%i==0){
                    return i;
                }
            }
        }
        return -1;
    }
}