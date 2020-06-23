package S09InnerAbstractClassInterfacesL122_134.L129_130AbstractClass;

/**
 * Created by dev on 7/10/2015.
 */
public class Dog extends Animal {

    /* You need to implement the constructor and the abstract methods*/

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat");

    }
}
