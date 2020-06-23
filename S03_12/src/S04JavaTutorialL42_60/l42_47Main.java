package S04JavaTutorialL42_60;

public class l42_47Main {
    public static void main(String[] args) {
        /*43 Keywords and expressions*/
        double km = 100 * 1.609344; // la expresión va de km hasta el final
        int score = 100; // Expresion: score..
        if (score > 99) { // Expresion: score..
            System.out.println("Great"); // Expresion: "Great"
        }

        /* 44. Statements, whitespaces and identation */
        int myVariable = 50; // All the line is de statement
        System.out.println("this is " +
                "anoter statenebt"); // This is a Statement

        // Whitespaces: java ignores them
        int myVariable2 = 20;  //

        // Identation: el sangrado. Code: Reformat Code Ctrl + Alt + L

        /*45. Code blocks ad the if then else*/
        boolean gameOver = true;
        int score2 = 5000;
        int levelCompleted = 5;
        int bonus =100;
        if(score==5000){ // This is a code block
            System.out.println("Your score was 5000");
            int score3=score2+bonus; // this variable is aneccsible outside the block
        } else {
            System.out.println("it wasnt 5000");
        }

        /*47. Métodos*/
        calculateScore(gameOver, score2, levelCompleted, bonus);
        calculateScore(gameOver, 10000, 8, 200);

        /* 48. Funciones y challenge*/
        /* 49. Final code changes */

    }

    /*47 Métodos */
    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        if(gameOver){
            int finalScore=score+(levelCompleted*bonus);
            finalScore += 1000;
            System.out.println("Final score: "+finalScore);
        }
    }

    // función
    public static int calculateScore2 (boolean gameOver, int score, int levelCompleted, int bonus){
        int finalScore=0;
        if(gameOver){
            finalScore=score+(levelCompleted*bonus);
            finalScore += 1000;
        }
        return finalScore;
    }


}
