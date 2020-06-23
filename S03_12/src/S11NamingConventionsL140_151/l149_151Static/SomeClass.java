package S11NamingConventionsL140_151.l149_151Static;

/**
 * Created by dev on 20/11/2015.
 */
public class SomeClass {

    //Instance counter

    // private static int classCounter = 0;
    public final int instanceNumber=4;
    private final String name;


    public SomeClass(String name) {
        this.name = name;
        //classCounter++;
        //instanceNumber ++;
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
