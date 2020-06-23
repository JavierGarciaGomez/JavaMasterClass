package S12CollectionsL152_178.try2_06_01.L160_161ImmutableClass;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    //160: change the constructor to accept Map exits
    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        // 160 we have to instantiate it again. Otherwise it can be modified from main
        // 161 Correction to be able to create exits without locations
        if (exits==null){
            this.exits = new HashMap<String, Integer>();
        }else{
            this.exits = new HashMap<String, Integer>(exits);
        }
        this.exits.put("Q",0);
    }

    // GETTERS
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }


//    // 160 Delete
//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

}
