package S04JavaTutorialL42_60;

public class l57_60MainOverloading {
    public static void main(String[] args) {
        /*57 Method overloading
        * Overloading is different from overwriting*/
        int newScore = calculateScore("Tim", 500);
        System.out.println("New Score: "+newScore);
        calculateScore(500);

        /*58. Recap*/
    }

    /*57 Method overloading*/
    public static int calculateScore(String playerName, int score){
        System.out.println(playerName+"score: "+score);
        return score*1000;
    }

    public static int calculateScore(int score){
        System.out.println("Unnamed player score: "+score);
        return score*1000;
    }
}
