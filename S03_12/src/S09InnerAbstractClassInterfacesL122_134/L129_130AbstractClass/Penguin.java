package S09InnerAbstractClassInterfacesL122_134.L129_130AbstractClass;

/**
 * Created by dev on 7/10/2015.
 */
public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println(getClass().getSimpleName()+" I'm not very good at that, can I go for a swim instead?");
    }
}
