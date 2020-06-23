package S07OOPIIL89_97.L90Composition;

public class Main {
    public static void main(String[] args) {
        /* 90. Composition
        * Compositiopn is like the parts of an object, like motherboard and processor for a computer
        * In the example the Resolution class is part of a monitor, so thats composition
        * Another example is PC that contains monitor, case and motherboard*/

        Case theCase = new Case ("220B", "Dell", "240", new Dimensions(20,20,20));
        Monitor monitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540,1440));
        Motherboard motherboard=new Motherboard("BJ-200","Asus",4,6,"v2.44");

        PC thePC = new PC(theCase, monitor, motherboard);

        // Access a methoid from a component
        thePC.getMonitor().drawPixelAt(1500, 1200, "red");
        thePC.getMotherboard().loadProgram("Windows 1.0");
        thePC.getTheCase().pressPowerButton();







    }
}
