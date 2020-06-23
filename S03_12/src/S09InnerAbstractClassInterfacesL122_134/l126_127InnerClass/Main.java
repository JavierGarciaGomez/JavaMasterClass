package S09InnerAbstractClassInterfacesL122_134.l126_127InnerClass;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner (System.in);
    private static Button button = new Button("Print");

    public static void main(String[] args) {
        /* 126. Inner classes
         * Four types of nested classes:
         *   1) Static nested class: Mainly used to associate a class with its outer class. So its identical to outer class, but is packaged in the outer class rather than package
         *   2) Non-static nested class (INNER CLASS):
         *   3) local class: A inner class defined inside a code block, usually a method
         *   4) Anonymous class: a nested class without a class name.
         *
         *
         *
         *  Innerclass (type 2): Gearbox class*/

        /* Se hace private la clase, por lo que este código no funciona
        // Instancia el GearBox
        Gearbox mmcLaren = new Gearbox(6);

        // Se instancia la clase interna Gear
        Gearbox.Gear first = mmcLaren.new Gear(1, 12.3);
        //        Gearbox.Gear second = new Gearbox.Gear(2,15.4)// Esto da error
        // Gearbox.Gear third = new mcLaren.Gear(3,17.8); // Esto también porque no hay new
        Gearbox.Gear gear = new Gearbox(3).new Gear(3,3); // But this is possible

        System.out.println(first.driveSpeed(1000));

        // normally the inner classes are private, so the instances are created by the other class

         */
        /* 127. Inner class p2 */

        Gearbox mcLaren = new Gearbox(6);
/*
        Deleted during 127, so it eliminates all the reference to the Gear innerclass
        mcLaren.addGear(1,5.3);
        mcLaren.addGear(3,3.15);
        mcLaren.addGear(2, 10.6);
*/
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println("The wheelspeed is " + mcLaren.wheelSpeed(1000));

        mcLaren.changeGear(2);
        System.out.println("The wheelspeed is "+mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println("The wheelspeed is "+mcLaren.wheelSpeed(6000));

        /* Con esto no se accesa para nada a la clase Gear
        * Otras clases internas son las anónimas y las locales
        * Las locales son declaradas en un bloque como en un método o statement, restringidos a esta.
        * Las anónimas Se verán después
        * Las locales se usan menos y son poco frecuentes, se verá en el ejemplo de la clase botón
        *
        * */

        // clase local que implementa la interfaz de la clase botón


        class ClickListener implements Button.OnClickListener{
            // constructor
            public ClickListener(){
                System.out.println("I've been attached");
            }

            public void onClick(String title){
                System.out.println(title+" was clicked");
            }
        }

        // El botón instanciado fuera se activa el método setOnClickListener y se le pasa por parámetro una instanciación de la clase local
        button.setOnClickListener(new ClickListener());

        // Clase anónima
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + "Was clicked");
            }
        });


        listen();

        // Finalmente las clases anónimas que no tienen nombre.
    }

    // método que sirva de escucha simulando el botón: 1 para clicar
    private static void listen(){
        boolean quit= false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                break;

                case 1:
                    button.onClick();
            }

        }
    }


}
