package S07OOPIIL89_97.L91Composition2;

public class PC {
    /*91 Composition*/
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    private Case getTheCase() {
        return theCase;
    }

    private Monitor getMonitor() {
        return monitor;
    }

    private Motherboard getMotherboard() {
        return motherboard;
    }

    /*91 Composition*/

    public void powerUp(){
        //getTheCase().pressPowerButton();
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        //getMonitor().drawPixelAt(1200,50,"yellow");
        monitor.drawPixelAt(1200,50,"yellow");

    }
}
