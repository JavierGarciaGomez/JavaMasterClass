package S05ControlFlowL61_74;

public class l62_Switch {
    public static void main(String[] args) {
        /*62. Switch*/
        int switchValue = 3;
        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
            case 3:
                case4:
                System.out.println("Value was 2, 3, 4");
                break;
            default:
                System.out.println("not 1 or 2");
                break;
        }

        /*63. Ejercicio 2*/
        System.out.println(isLeapYear(-1600) + " " + isLeapYear(1600) + isLeapYear(2017) + isLeapYear(2000) + isLeapYear(-1024));
        System.out.println(getDaysInMonth(1, 2020) + " " + getDaysInMonth(2, 2020) + " " + getDaysInMonth(2, 2018)
                + " " + getDaysInMonth(-1, 2020) + " " + getDaysInMonth(1, -2020));
    }
    /*63. Ejercicio 2*/

    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0 && ((year % 100 != 0) || (year % 400 == 0))) {
                return true;
            } else return false;
        } else return false;

    }


    public static int getDaysInMonth(int month, int year) {
        if (year >= 1 && year <= 9999) {
            switch (month) {
                case 2:
                    if (isLeapYear(year)) {
                        return 29;
                    } else return 28;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return -1;
            }
        }
        return -1;
    }
}
