package S20.l365;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");

            System.out.println("FIRST WAY");
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            while(line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }

            System.out.println("SECOND WAY");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            inputStream = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            line = "";
            while(line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();

        } catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
