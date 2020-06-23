package S10GenericsL135_139;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        // This arraylist could be generic ife doesn't specify the type of data. But this is never recommended
        ArrayList items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add("tim"); // If the arraylist hasn't a parameter specified it can accept this

        items = new ArrayList<Integer>();
        items.add(1);
        items.add(2);


        printDoubledAsObject(items);
        printDoubled(items);

        /* 136. Our generic class*/
        System.out.println("***********136***********");

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team adelaideCrows = new Team("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        adelaideCrows.addPlayer(pat);
        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.getNumPlayers());

        Team anotherTeam = new Team("AnotherTeam");

        adelaideCrows.matchResult(anotherTeam, 1,2);
        adelaideCrows.ranking();

        anotherTeam.ranking();






        /*137. Our Generics P2
        Using the generic class Team*/
        System.out.println("***********137***********");
        //Applying the generics
        Team<FootballPlayer> footballPlayerTeam = new Team<>("footballPlayerTeam");
        footballPlayerTeam.addPlayer(joe);
        // Now We can't add another kind of players
        // footballPlayerTeam.addPlayer(pat);

        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Chicaco Cubs");
        baseballPlayerTeam.addPlayer(pat);

        // Now our problem is the generic accepts any kind of object, ie: Strings
        // Team<String> brokenTeam = new Team<>("A String");

        Team<FootballPlayer> melbourne = new Team <> ("Melbourne");
        Team<FootballPlayer> hawthorn = new Team <> ("Hawthorn");
        Team<FootballPlayer> fremantle = new Team <> ("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle,2 ,1);
        adelaideCrows.matchResult(baseballPlayerTeam, 3,3);


        hawthorn.ranking();
        fremantle.ranking();
        adelaideCrows.ranking();

        // We cant do this, because in the method we specify the generic
        // footballPlayerTeam.matchResult(baseballPlayerTeam, 2, 2);

        System.out.println(fremantle.compareTo(adelaideCrows));

        System.out.println("***********139 Challenge***********");


        League <Team<FootballPlayer>> footballLeague = new League("Football League");
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);
        footballLeague.add(adelaideCrows);

        melbourne.matchResult(fremantle, 4, 11);
        melbourne.matchResult(hawthorn, 4, 13);

        footballLeague.showLeagueTable();












    }

    private static void printDoubledAsObject(ArrayList aL){
        for(Object o : aL) {
            System.out.println( (Integer) o * 2);
        }
    }

    private static void printDoubled(ArrayList<Integer> n) {
        for(int i : n) {
            System.out.println( i * 2);
        }
    }
}
