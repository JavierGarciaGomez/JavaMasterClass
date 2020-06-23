package S09InnerAbstractClassInterfacesL122_134.L129_130AbstractClass;

public class Main {

    public static void main(String[] args) {
        /* 129 Abstract class:
        * In interfaces So abstraction is when you define the required functionality for
        * something without actually implementing the data house.
        * In other words we're focusing on what needs to be done, not on the how it's to be done.
        *
        * Recommendation that you should do that whenever you are using a list of some type in your programs.
        * Generally speaking in terms of the declaration, it's good to write it like that and that leaves
        *  your implementation open to actually use any type of that is anything that implements that
        * particular interface in which case this is the list interface which part of Java
        *
        * Including, one can remove the type of data and leave the list empty, and the user defines the type of data
        * when he declares it.
        *
        * The example is the class animal  */

	    Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Australian ringneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();

        Animal pet = new Parrot("juan");

    }
}
