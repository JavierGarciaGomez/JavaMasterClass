package S14BasicInputOutput.l238ReadingBinaryData;

import java.io.*;
import java.util.*;

// Implements Map interface
public class Locations implements Map<Integer, Location> {
    // Hashmap of the locations
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        //DataOutputStream
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new
                FileOutputStream("locations.dat")));) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationID() + " " + location.getDescription());
                System.out.println("Writing exits");// Writing exits
                locFile.writeInt(location.getExits().size() - 1);
                for (String exit : location.getExits().keySet()) {
                    if (!exit.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + exit + "," + location.getExits().get(exit));
                        locFile.writeUTF(exit);
                        locFile.writeInt(location.getExits().get(exit));
                    }
                }
            }
        }
    }

    // static init: contains all the locations ant its exits
    static {

        try (DataInputStream locFile = new DataInputStream(new
                BufferedInputStream(new FileInputStream("locations.dat")))) {
            // READING THE LOCATIONS
            while(true){
                // Locations dat contains: id, desc, exitsSize, exitLocn, exitIdn
                Map<String, Integer> exits = new LinkedHashMap<>();
                int locId = locFile.readInt();
                String desc = locFile.readUTF();
                int numExits = locFile.readInt();
                System.out.println("Read location "+ locId+" : "+desc);
                System.out.println("Found "+numExits+"exits");
                for(int i=0; i<numExits;i++){
                    String direction = locFile.readUTF();
                    int destination = locFile.readInt();
                    exits.put(direction, destination);
                    System.out.println("\t\t"+direction+","+destination);
                }
                locations.put(locId, new Location(locId, desc, exits)); // put it in locations
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // READING THE EXITS
        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int locId = Integer.parseInt(data[0]);
                String direction = data[1];
                int exitId = Integer.parseInt(data[2]);

                System.out.println(locId + direction + exitId);

                Location location = locations.get(locId);
                location.addExit(direction, exitId);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
