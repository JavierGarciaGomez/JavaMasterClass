package S11NamingConventionsL140_151.l149_151Static;

/**
 * Created by dev on 20/11/2015.
 */
public class StaticTest {
    private int nonStaticNum = 0;
    private static int numInstances = 0;
    private String name;


    public StaticTest(String name) {
        this.name = name;
        numInstances++;
        nonStaticNum++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public int getNonStaticNum() {
        return nonStaticNum;
    }


    public int getNumInstanceAsVarOfInstance() {
        return numInstances;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StaticTest{" +
                "nonStaticNum=" + nonStaticNum +
                "StaticNum=" + numInstances +
                ", name='" + name + '\'' +
                '}';
    }
}
