package S07OOPIIL89_97.L92_93Encapsulation;

public class Main {

    public static void main(String[] args) {
	    Player player = new Player();
        player.name = "Tim";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health =  " + player.healthRemaining());

        damage = 11;
        player.health = 200;
        player.loseHealth(damage);
        System.out.println("Remaining health =  " + player.healthRemaining());

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Tim", 200, "Sword");
        System.out.println("Initial health is " + enhancedPlayer.getHealth());

        /*93. Challenge Printer*/
        Printer printer = new Printer (true);
        printer.fillToner(1);
        printer.printingPages(17);
        System.out.println("printed pages "+printer.getNumberPagesPrinted());
        printer.fillToner(1.5);




    }
}
