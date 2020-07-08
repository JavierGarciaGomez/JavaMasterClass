package S20.l361;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            // Input
            BufferedReader echoes = new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            // Output
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString; // Output
            String response; // Input

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                // sending the String
                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
