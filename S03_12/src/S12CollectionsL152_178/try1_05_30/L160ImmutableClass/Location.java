package S12CollectionsL152_178.try1_05_30.L160ImmutableClass;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        // 161 Challenge correction: possibility to add a null location
        if(exits!=null){
            this.exits = new HashMap<String, Integer>(exits);
        } else{
            this.exits= new HashMap<String, Integer>();
        }

        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
