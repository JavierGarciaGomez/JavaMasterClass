package S06OOPIL75_88;

import java.util.Objects;

public class l75_79Classes_Constructors {
    public static void main(String[] args) {
        /* 76. Class
    Objects have state and behavior or fields and methods
    Createa java class with public fields
    access them*

    77. Class part 2:
    Setters Getters/
     */

        /* 77 Ex 2:*/
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4);
        System.out.println(calculator.getAdditionResult());
        System.out.println(calculator.getSubtractionResult());
        calculator.setFirstNumber(5.25);
        calculator.setSecondNumber(0);
        System.out.println(calculator.getMultiplicationResult());
        System.out.println(calculator.getDivisionResult());

        /* 78 Constructores
        * Calling another constructor with this
        * */

        /* 79. Constructors 2
        * Tip: Set the fields in the constructor with this; and not call the setters of the class when initializating
        * Tip: call a more full constructor with an semiempty constructor*/

        /* 79. Exercise 32 */
        Point first = new Point (6,5);
        Point second = new Point (3,1);
        System.out.println(first.distance());
        System.out.println(first.distance(second));
        System.out.println(first.distance(2,2));
        Point point = new Point();
        System.out.println(point.distance());

        /* 80. Inheritance
        * Class Animal, and dog
        * Super for call the constructor of the superclass
        * Extrafields for the subclass
        * Override methods*/

        /* 81. Inheritance 2
        * */

        /*82. Reference vs object vs instance vs class */
        /* 83 This vs Super*/

        /* 87.
        * All classes inheritance from objects*/


    }


}
