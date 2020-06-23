package S04JavaTutorialL42_60;

public class l56_Ejercicio2 {

    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);
        printMegaBytesAndKiloBytes(-1024);
        printMegaBytesAndKiloBytes(5000);
    }


    public static void printMegaBytesAndKiloBytes(int kiloBytes){

        if (kiloBytes<0){
            System.out.println("Invalid Value");
        }
        else{
            int XX=kiloBytes;
            int YY=XX/1024;
            int ZZ=XX%1024;
            System.out.println(XX+" KB = "+YY+" MB and "+ZZ+" KB");
        }
    }
}
