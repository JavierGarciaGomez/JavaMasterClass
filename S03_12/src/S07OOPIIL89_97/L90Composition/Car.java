package S07OOPIIL89_97.L90Composition;

public class Car extends Vehicle {

    /*90 Composition*/
    private int doors;
    private int engineCapacity;

    public Car(String name, int doors, int engineCapacity) {
        super(name);
        this.doors = doors;
        this.engineCapacity = engineCapacity;
    }


}
