package l235_236Challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Implements Map interface
public class Locations implements Map<Integer, Location> {
    // Hashmap of the locations
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    // static init: contains all the locations ant its exits
    static {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("locations_big.txt"))){
            // READING THE LOCATIONS
            String input;
            while((input=bufferedReader.readLine())!=null){ // Loop the txt
                String [] data = input.split(",");
                int locId= Integer.parseInt(data[0]); // read the locId
                String locDesc = data[1]; // read the locDesc

                System.out.println("FileReader "+locId+" "+locDesc);

                // Create a hashmap of the exit, initially void
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(locId, new Location(locId, locDesc, tempExit));
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        // READING THE EXITS
        try(BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))){
            String input;
            while((input=dirFile.readLine())!=null){
                String[] data = input.split(",");
                int locId= Integer.parseInt(data[0]);
                String direction=data[1];
                int exitId=Integer.parseInt(data[2]);

                System.out.println(locId+direction+exitId);

                Location location = locations.get(locId);
                location.addExit(direction, exitId);
                }
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
