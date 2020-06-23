package S03FirstStepsL19_41;

public class Main {
    public static void main(String[] args) {
        /* 20. Defining Main Method*/
        System.out.println("Hello World");

        /* 21. Change name*/
        System.out.println("HEllo, Javier");

        /* 22. Variables         */
        int myNumber=5;
        System.out.println("my number is "+myNumber);
        System.out.println((10+5)+(2*10));

        /* 23. Expressions */
        int mySecondNumber =12;
        int myThirdNumber =6;
        int myTotal;
        myTotal=myNumber+mySecondNumber+myThirdNumber;
        System.out.println(myTotal);

        int myLastOne = 1000-myTotal;
        System.out.println(myLastOne);

        /* 24. Primitive Types*/
        //INT
        System.out.println("Integer: "+Integer.MIN_VALUE+" "+Integer.MAX_VALUE);
        System.out.println("Busted MAX VALUE: Esto es un OVERFLOW"+(Integer.MAX_VALUE+1));

        // Es válido escribir números con guiones bajos
        System.out.println(2_147_483_647);

        /*25 Byte, short, long, width*/
        //Byte
        System.out.println("Byte: "+Byte.MIN_VALUE+" "+Byte.MAX_VALUE);
        //Short
        System.out.println("Short: "+Short.MIN_VALUE+" "+Short.MAX_VALUE);
        //Long
        System.out.println("Long: "+Long.MIN_VALUE+" "+Long.MAX_VALUE);
        long myLong =1000; // Necesita una L al final si es mayor a un Integer

        /*26. Casting*/
        byte myByte = Byte.MAX_VALUE;
        // byte myNewByte = myByte/2; No permite hacerlo, se debe hacer casting:
        byte myNewByte = (byte) (myByte/2);

        /*27. Challenge*/
        byte byteValue = 10;
        short shortValue = 20;
        int intValue = 50;
        Long longTotal = 50000L + 10L *(byteValue+shortValue+intValue);
        System.out.println(longTotal);
        // There was no need of casting, en cambio en short sí
        Short shortTotal = (short)(50000L + 10L *(byteValue+shortValue+intValue));

        /* 28. Float and double*/
        //Float
        System.out.println("Float: "+Float.MIN_VALUE+" "+Float.MAX_VALUE);
        //Double
        System.out.println("Double: "+Double.MIN_VALUE+" "+Double.MAX_VALUE);

        /*29. Floating point precision*/
        int myInt = 5/3;
        float myFloat = 5f/3f;
        double myDouble = 5d/3d;
        System.out.println(myInt+" "+myFloat+" "+myDouble);
        // 1 1.6666666 1.6666666666666667

        // Se recomienda más el uso de double, porque es el estándar y las computadoras modernas lo procesan rápido
        // Challenge convert pounds to kg

        /* 30. The char and boolean */
        char myChar = 'D';
        char myUnicode= '\u0044';
        int myCharInt = (int)myChar;
        char myCRChar = '\u00A9';
        System.out.println(myChar+" "+myUnicode+" "+myCharInt+" "+myCRChar);

        boolean myBoolean = true;
        boolean isACustomer = true; // Suelen formularse como preguntas
        System.out.println(myBoolean);

        /* 31. String */
        String myString = "This is a String";
        System.out.println("My String: "+myString);

        /* 32. Operators         */
        int result = 1+2; // Operators: + & =

        // + - * / %

        /* 33. Abbreviating operators */
        result = 1;
        result++;
        System.out.println(result);
        result--;
        System.out.println(result);
        result+=2;
        System.out.println(result);
        result-=2;
        System.out.println(result);
        result*=10;
        System.out.println(result);

        /* 34. If then */
        boolean isAlien=false;
        if(isAlien==false){
            System.out.println("Is it not an alien");
        }

        /*35. Logical and operator
        * ==
        * =!
        * <
        * <=
        * >=
        * &&
        * ||
        * */

        /* 36. Logical Or
        * ||
        * */

        /* 37. Assignment operatos VS Equal operator
        * =      ==      */
        // Un condicional if requiere un boole su condición
        boolean isCar=true;
        if(isCar){

        }
        if(isCar==true){

        }
        if(!isCar){

        }

        /* 38. Ternary operator */
        boolean wasCar = isCar? true: false; // la pregunta, la condición verdadera y la falsa.

        /* 39. Challenge*/




    }
}
