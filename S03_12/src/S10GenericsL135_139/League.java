package S10GenericsL135_139;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team> {
    private String name;
    private ArrayList<T> league = new ArrayList<T>();

    public League(String name){
        this.name=name;
    }

    public boolean add(T team){
        if(league.contains(team)){
            return false;
        }
        league.add(team);
        return true;
    }

    public void showLeagueTable(){
        System.out.println("Showing the table");
        Collections.sort(league);
        System.out.println("After sort");
        int position=1;
        for(Team t:league){
            System.out.println(position+"º "+t.getName()+" with "+t.ranking()+" points of "+t.played+" played games");
            position++;
        }

    }

}
