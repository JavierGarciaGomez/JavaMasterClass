package S09InnerAbstractClassInterfacesL122_134.L129_130AbstractClass;

/**
 * Created by dev on 7/10/2015.
 */
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // Abstract methods
    public abstract void eat();
    public abstract void breathe();

    public void test(){
        System.out.println("I can implement this method");
    }

    public String getName() {
        return name;
    }
}
