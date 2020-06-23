package S07OOPIIL89_97.L95Polymorfism2;

public class Car {
    // We are going to go back to the car analogy.
    // Create a base class called Car
    // It should have a few fields that would be appropriate for a generice car calss.
    // engine, cylinders, wheels, etc.
    // Constructor should initialize cylinders (number of) and name, and set wheels to 4
    // and engine to true. Cylinders and names would be passed parameters.
    //
    // Create appropriate getters
    //
    // Create some methods like startEngine, accelerate, and brake
    //
    // show a message for each in the base class
    // Now create 3 sub classes for your favorite vehicles.
    // Override the appropriate methods to demonstrate polymorphism in use.
    // put all classes in the one java file (this one).

    public static void main(String[] args) {
        Car car = new Tsuru("MiCoche", 4);
        car.startEngine();
        car.accelerate();
        car.brake();

    }

    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        engine=true;
        wheels=4;
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public void startEngine(){
        System.out.println("car ---> Engine started");
    }

    public void accelerate(){
        System.out.println(" car ---> accelerate");
    }

    public void brake(){
        System.out.println("car ---> break");
    }

}

class Tsuru extends Car{

    public Tsuru(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println(getClass().getSimpleName());
        System.out.println("Tsuru ---> Start engine");
    }

    @Override
    public void accelerate() {
        super.accelerate();
        System.out.println("Tsuru ----> Accelerate");
    }

    @Override
    public void brake() {
        super.brake();
        System.out.println("Tsuru ----> brake");
    }
}