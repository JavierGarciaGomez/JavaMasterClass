package S07OOPIIL89_97.L91Composition2;

public class Main {
    public static void main(String[] args) {
        /* 91. Composition
        * In this example we execute a method from pc, that has components monitor, case and motherboard
        * This powerUp() method executes a method from an object case: pressPowerButton and a proper method: drawLogo
        * With theCase.pressPowerButtton(): it prints a message.
        * With drawlogo() it executes a method from an object monitor: drawPixelAt();
        * With drawPixelAt() it prints a message with a point, simulating a logo
        * */

        Dimensions dimensions=new Dimensions (20,20,5);
        Case theCase = new Case ("220B", "Dell", "240", dimensions);
        Monitor monitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540,1440));
        Motherboard motherboard=new Motherboard("BJ-200","Asus",4,6,"v2.44");

        PC thePC = new PC(theCase, monitor, motherboard);

        // Access a methoid from a component
//        thePC.getMonitor().drawPixelAt(1500, 1200, "red");
//        thePC.getMotherboard().loadProgram("Windows 1.0");
//        thePC.getTheCase().pressPowerButton();

        /*
        *         * In this example we execute a method from pc, that has components monitor, case and motherboard
         * This powerUp() method executes a method from an object case: pressPowerButton and a proper method: drawLogo
         * With theCase.pressPowerButtton(): it prints a message.
         * With drawlogo() it executes a method from an object monitor: drawPixelAt();
         * With drawPixelAt() it prints a message with a point, simulating a logo
         *
         * ¿When to use inheritance and when composition?
         * Look first composition before than inheritance. But that thepends
         * */

        thePC.powerUp();

        /* 91. Challenge
        // Create a single room of a house using composition.
        // Think about the things that should be included in the room.
        // Maybe physical parts of the house but furniture as well
        // Add at least one method to access an object via a getter and
        // then that objects public method as you saw in the previous video
        // then add at least one method to hide the object e.g. not using a getter
        // but to access the object used in composition within the main class
        // like you saw in this video.
        * */

        Bed bed = new Bed("Modern", 2, 1, 3, 1);
        Lamp lamp = new Lamp ("Classic", false, 4);

        Bedroom bedroom = new Bedroom("bedroom", new Wall("north"), new Wall("south"),
                new Wall("east"), new Wall("west")
                , new Ceiling(2, "red"), bed, lamp);

        bedroom.makeBed();
        bedroom.getLamp().turnOn();
    }
}
