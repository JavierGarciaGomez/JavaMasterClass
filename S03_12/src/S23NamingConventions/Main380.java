package S23NamingConventions;

public class Main380 {
    public static void main(String[] args) {
        //380
        double milesDrivenMonth;
        int visitorsDay;
        char lastKeyPressed;

        // 381
        double km = (100*1.603944);
        System.out.println(km);

        //382
        // Declaration statement
        int finalScore=50;

        // Expression Statement
        finalScore=70;

        // Control flow Statemen
        if (finalScore>70) System.out.println("bien");

        // 383
        int playerLives = 3;
        // postfix
        System.out.println(playerLives++);
        // prefix
        System.out.println(++playerLives);

        // 384 Whitespaces
        playerLives
                =
                12;

        playerLives = 23; playerLives =24;

        // 385

        //386 Codeblocks if then, if else
        finalScore=5000;
        if(finalScore==5000) System.out.println("You got the high score");
        System.out.println("this was executed");

        if(finalScore==4000) System.out.println("You got the high score");
        System.out.println("this was executed");

        if(finalScore==4000) {
            System.out.println("You got the high score");
            System.out.println("this was executed");
        }

        if(finalScore<5000) {
            System.out.println("You score was less than 5000");
        } else{
            System.out.println("You got here");
        }

        if(finalScore<5000) System.out.println("You score was less than 5000");
        else System.out.println("You got here");

        //387 boolean naming convention

        boolean isGameOver = true;
        int levelCompleted = 5;
        int bonus = 100;
        int score =800;

        if (isGameOver==true){
            finalScore=score +(levelCompleted*bonus);
            System.out.println("Your final score was: "+finalScore);
        }

        // 388 Challenge
        if (isGameOver==true){
            finalScore=score +(levelCompleted*bonus);
            System.out.println("Your final score was: "+finalScore);
        }

        levelCompleted = 8;
        bonus = 200;
        score =10000;

        if (isGameOver==true){
            finalScore=score +(levelCompleted*bonus);
            System.out.println("Your final score was: "+finalScore);
        }

        // 389 Defining methods
        // 390 Executing methods
        // 391 Method parameters
        calculateScore(true, 1000, 5, 200);


    }

    public static void calculateScore(boolean isGameOver, int score,
                                      int levelCompleted, int bonus){

        int finalScore;

        if (isGameOver==true){
            finalScore=score +(levelCompleted*bonus);
            System.out.println("Your final score was: "+finalScore);
        }



    }

}
