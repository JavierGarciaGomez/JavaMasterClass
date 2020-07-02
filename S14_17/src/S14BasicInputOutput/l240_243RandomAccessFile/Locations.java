package S14BasicInputOutput.l240_243RandomAccessFile;

import java.io.*;
import java.util.*;

// static init: contains all the locations ant its exits
/*
 * 240:
 * File Pointer is an aoffset in the fine where the next write or read goin to start from.
 * If We were at point 100, and read an int We are going to pass from 100 to 103, because an int is 4 bytes
 *
 * An offset is a byte location in the file
 *
 * Every index record has to be the same length
 * Our app is going to have the location id, the location offset and its record lenth.
 * Because of our description, the record will be longer than 12 bytes.
 * We can load into memory the index or read it in a file. Load it into memory is faster
 *
 * 1. First 4 bytes contain the number of locations (0-3).
 * 2. Next  4 the start offset of the location section.
 * 3. The next section, contain the index . Bytes: 8-1699
 * 4. The final section will contain the location record (the data). It will start at byte 1700
 *
 * */

public class Locations implements Map<Integer, Location> {
    // Hashmap of the locations
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile raf;


    public static void main(String[] args) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("locations_rand.dat", "rwd")) {
            randomAccessFile.writeInt(locations.size()); // Write 4 bytes for locationssize (0-3)
            int indexSize = locations.size()*3*Integer.BYTES; // Get the index size multiplicating the int in each location
            int locationStart = (int) (indexSize+randomAccessFile.getFilePointer()+Integer.BYTES);
            randomAccessFile.writeInt(locationStart); // Writing the locationStart int
            long indexStart = randomAccessFile.getFilePointer(); // getting the file pointer

            int startPointer = locationStart;
            randomAccessFile.seek(startPointer);

            for(Location location:locations.values()){
                randomAccessFile.writeInt(location.getLocationID()); // Writing the locationID
                randomAccessFile.writeUTF(location.getDescription()); // Write the desc ID
                StringBuilder builder = new StringBuilder(); // StringBuilder para almacenar información
                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){ // Writing all the info of each exit
                      builder.append(direction);
                      builder.append(",");
                      builder.append(location.getExits().get(direction));
                      builder.append(",");
                    }
                }
                randomAccessFile.writeUTF(builder.toString()); // Writing the info of exits

                IndexRecord record = new IndexRecord(startPointer, (int)(randomAccessFile.getFilePointer()-startPointer)); // Create an indexRecord with the current pointer - start pointer
                index.put(location.getLocationID(), record); // put the record in a LinkedHashMap
                startPointer = (int) randomAccessFile.getFilePointer(); // Change the startpointer
            }
            randomAccessFile.seek(indexStart);
            for(Integer locationID : index.keySet()){ // Looping through the index records and writing them into the file
                randomAccessFile.writeInt(locationID);
                randomAccessFile.writeInt(index.get(locationID).getStartByte());
                randomAccessFile.writeInt(index.get(locationID).getLength());
            }
        }
    }


    static {
        try {
            raf = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations= raf.readInt(); // read locations size
            long locationStartPoint = raf.readInt(); // read location startpoint

            while(raf.getFilePointer()<locationStartPoint){ // loop through each location
                int locationId =raf.readInt();
                int locationStart= raf.readInt();
                int locationLength = raf.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
}

    public Location getLocation(int locationId) throws IOException{
        IndexRecord record = index.get(locationId);
        raf.seek(record.getStartByte());
        int id = raf.readInt();
        String desc = raf.readUTF();
        String exits = raf.readUTF();
        String[] exitPart = new String(exits).split(",");

        Location location = new Location(id, desc, null);


        if(locationId!=0){
            for(int i=0; i<exitPart.length;i++){
                System.out.println("exitPart = "+exitPart[i]);
                System.out.println("exitPart[+1] = "+exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
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

    //243
    public void close() throws IOException{
        raf.close();
    }
}
