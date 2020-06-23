package S14BasicInputOutput.L244NIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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
        // Is more complex a Path but here is similar to a File class, but NIO just accept PATH and not File
        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {

            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + " ," +
                                location.getExits().get(direction) + "\n");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }

    static {

        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");

        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                locations.put(loc, new Location(loc, description, null));
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

    //243
    public void close() throws IOException {
        raf.close();
    }
}
