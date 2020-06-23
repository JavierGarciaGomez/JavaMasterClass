package S07OOPIIL89_97.L92_93Encapsulation;

public class Printer {
    private double tonerLevel;
    private int numberPagesPrinted;
    private boolean isDuplex;

    public Printer(boolean isDuplex) {
        this.isDuplex = isDuplex;
    }

    public void fillToner(double ammountFilled){
        if(tonerLevel+ammountFilled>1.0){
            System.out.println("You can fill it just al 100%, not more");
            tonerLevel=1.0;
        } else {
            tonerLevel=+ammountFilled;
            System.out.println("Your toner level is: "+tonerLevel);
        }
    }

    public void printingPages (int printedPages){
        for (int i=1; i<=printedPages;i++){
            if(tonerLevel>0.05){
                numberPagesPrinted++;
                tonerLevel-=0.05;
            } else{
                System.out.println("sorry, you are out of toner. Please change");
            }
        }

    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberPagesPrinted() {
        return numberPagesPrinted;
    }
}
