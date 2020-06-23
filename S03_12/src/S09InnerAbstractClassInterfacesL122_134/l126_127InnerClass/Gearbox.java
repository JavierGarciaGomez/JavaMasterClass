package S09InnerAbstractClassInterfacesL122_134.l126_127InnerClass;

import java.util.ArrayList;

/**
 * Created by dev on 2/10/2015.
 */
public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        // Se inicia el arraylist
        this.gears = new ArrayList<>();
        // Se instancia la clase interna, con el objeto neutral
        Gear neutral = new Gear(0, 0.0);
        // Se añade este elemento al arraylist
        this.gears.add(neutral);

        // Se añade al arraylist todos los gears posibles (máximo) con una ratio multipo de 5.3
        for(int i=0; i<maxGears; i++) {
            addGear(i, i* 5.3);
        }
    }

    // Para activar el cluch
    public void operateClutch(boolean in) {
        System.out.println("Operating clutch "+in);
        this.clutchIsIn = in;
    }

    /// Para agregar más gears, siempre que el número no sea mayor al máximo
    public void addGear(int number, double ratio) {
        if((number >0) && (number <= maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    // Para cambiar el gear existente
    public void changeGear(int newGear) {
        //Condiciones: gear mayor a cero, menor al tamaño del array y el clutch activado
        if((newGear>=0 ) && (newGear <this.gears.size()) && this.clutchIsIn) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("Can't chage to gear "+ newGear+" Grind!");
            this.currentGear = 0;
        }
    }

    // Devolver velocidad, con parámetro de revoluciones
    public double wheelSpeed(int revs) {
        // Clutch activado devuelve cero
        if(clutchIsIn) {
            System.out.println("The clutch is in: Scream!!!");
            return 0.0;
        }
        // Clutch sin activar devuelve el método de la clase gear getRatio
        return revs * gears.get(currentGear).getRatio();
    }



    // INNER NESTED CLASS
    private class Gear {
        // Si las variables tuvieran el mismo nombre habría que poner Gearbox.this.gearNumber
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {

            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs) {
            return revs *( this.ratio);
        }
    }
}
