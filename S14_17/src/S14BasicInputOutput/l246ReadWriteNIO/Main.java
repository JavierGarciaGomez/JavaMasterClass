package S14BasicInputOutput.l246ReadWriteNIO;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            /*FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();*/
            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(dataPath);
            for(String line:lines){
                System.out.println(lines);
            }

        } catch(IOException exception){
            exception.printStackTrace();
        }

    }
}
