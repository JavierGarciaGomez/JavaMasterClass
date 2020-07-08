package S20.l362;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            socket.setSoTimeout(5000); // timeout
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

        } catch (SocketTimeoutException ex) {
            System.out.println("Time run out");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
