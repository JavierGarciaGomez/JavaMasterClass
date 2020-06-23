package S14BasicInputOutput.l239ObjectStreamSerialization;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
//Serializable
public class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    private final long serialVersionUID = 1L; // Serial Version

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new LinkedHashMap<String, Integer>(exits);
        } else {
            this.exits = new LinkedHashMap<String, Integer>();
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
        return new LinkedHashMap<String, Integer>(exits);
    }

    public void addExit(String direction, int exitId) {
        this.exits.put(direction,exitId);
    }
}
