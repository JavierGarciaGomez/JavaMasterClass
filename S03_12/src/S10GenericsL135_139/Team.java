package S10GenericsL135_139;

import java.util.ArrayList;

/**
 * Created by dev on 17/10/2015.
 */

    // With the diamond we turn it into a Generic class
    // Whit the extends we just accept player
    // We can bound with multiple interfaces
    //public class Team <T extends Player & Coach>{
    // Comparable interface
public class Team <T extends Player> implements Comparable<Team<T>>{

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            // Because is a generic, we need to cast it as a Player
            //System.out.println(((Player) player).getName() + " is already on this team");
            // But when We extend it as a player in the class definition we dont need the casting
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println((player.getName() + " picked for team " + this.name));
            return true;
        }
    }

    public int getNumPlayers() {
        return this.members.size();
    }

    public void matchResult(Team <T> opponent, int ourScore, int theirScore) {
        if(ourScore > theirScore) {
            won++;
        } else if(ourScore == theirScore) {
            tied++;
        } else {
            lost++;
        }
        played++;
        // Recursividad: Para ejecutar este mismo código para el oponente
        if(opponent != null) {
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        //System.out.println(name+" points: "+((won * 2) + tied));
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking()>team.ranking()){
            return -1;
        } else if (this.ranking()<team.ranking()){
            return 1;
        } else
        return 0;
    }

}























