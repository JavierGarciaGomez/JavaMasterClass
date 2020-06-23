package S12CollectionsL152_178.try2_06_01.l165SetsHashSets4;

public class Main {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover)+" returns true because rover is a Labrador and a Dog");
        System.out.println(rover.equals(rover2)+" returns false because rover2 is a Dog but not a Labrador");

        Poodle poodle = new Poodle("Rover");
        System.out.println(poodle.equals(rover2)+" returns true because both of them are dogs and Poodle doesnt override the equals method");
    }
}
