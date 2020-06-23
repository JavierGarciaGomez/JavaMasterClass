package S11NamingConventionsL140_151.l149_151Static;

public class Main {

    public static int multiplier =7;
    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest("First instance");
        System.out.println(staticTest.toString());
        StaticTest staticTest2 = new StaticTest("Second instance");
        System.out.println(staticTest2.toString());
        StaticTest staticTest3 = new StaticTest("Third instance");
        System.out.println(staticTest3.toString());
        System.out.println(StaticTest.getNumInstances());

        System.out.println(multiply(6));

        // 150 Final Statement
        SomeClass someClass = new SomeClass("one");
        SomeClass someClass1 = new SomeClass("two");
        SomeClass someClass2 = new SomeClass("three");

        int pw = 1234;
        Password password = new Password(pw);
        password.storePassword();
        password.letMeIn(1);
        password.letMeIn(1234);

        // 151 Final part 2
        System.out.println("************* FINAL PART 2*********");
        pw = 1234;
        // Now is saved without decryption
        password = new ExtendedPassword(pw);
        password.storePassword();

        // But if you made the method storePassword final it cannot be overwritten, or even the class as final

        StaticInitializationBlock staticInitializationBlock = new StaticInitializationBlock();
        staticInitializationBlock.someMethod();


    }

    public static int multiply(int number){
        return number*multiplier;
    }

}
