package S09InnerAbstractClassInterfacesL122_134.L129_130AbstractClass;

/**
 * Created by dev on 7/10/2015.
 */
public abstract class Bird extends Animal implements CanFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println(getName()+"Breathe in, breathe out, repeat");

    }

    public void fly(){
        System.out.println(getName()+ " is flapping his wings");
    };
}
