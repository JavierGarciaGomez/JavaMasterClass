package l234_LoadBigFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
* 233 BufferedReader
* A BufferedReader read textx from the input stream and buffers the characters into a character array
* Reading a chunk of characters is faster than reading it one by one, so bufferedReaderes are much faster
*
* */

// Implements Map interface
public class Locations implements Map<Integer, Location> {
    // Hashmap of the locations
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        /*try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")
        ) {
            // for each location
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                // for each exit of the location (each exit is a <locationDesc, locationId>)
                for(String direction:location.getExits().keySet()){
                    // Write: locationId+direction+the id of the location of the exit
                    dirFile.write(location.getLocationID()+","+direction+","+location.getExits().get(direction)+"\n");
                }
            }
        }*/
    }

    // static init: contains all the locations ant its exits
    static {
        Scanner scanner = null;
        try{
            // READING THE LOCATIONS
            // scan the filereader
            scanner=new Scanner(new FileReader("locations_big.txt"));
            scanner.useDelimiter(","); // , as a delimiter between elements of each line
            while(scanner.hasNextLine()){ // Loop the txt
                int locId=scanner.nextInt(); // read the locId
                scanner.skip(scanner.delimiter()); //Skip the ,
                String locDesc = scanner.nextLine(); // read the locDesc
                System.out.println("FileReader "+locId+" "+locDesc);

                // Create a hashmap of the exit, initially void
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(locId, new Location(locId, locDesc, tempExit));
            }
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            if(scanner!=null){
                scanner.close();
            }
        }

        // READING THE EXITS
        try{
            scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
/*
                int locId=scanner.nextInt(); // locId
                scanner.skip(scanner.delimiter());
                String direction = scanner.next(); // direction
                scanner.skip(scanner.delimiter());
                String exitIdString = scanner.nextLine(); // idString
                int exitId = Integer.parseInt(exitIdString);
*/
                String input = scanner.nextLine();
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
        } finally {
        if(scanner!=null){
            scanner.close();
        }
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
