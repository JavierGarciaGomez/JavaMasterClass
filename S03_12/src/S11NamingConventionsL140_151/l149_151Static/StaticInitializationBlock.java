package S11NamingConventionsL140_151.l149_151Static;

public class StaticInitializationBlock {
    public static final String owner;

    static{
        owner = "JGG";
        System.out.println("Static initialization block called");

    }

    public StaticInitializationBlock() {
        System.out.println("SIB constructor called");
    }

    static{
        System.out.println("SIB second static initialization called");
    }

    public void someMethod(){
        System.out.println("some method called");
    }
}
