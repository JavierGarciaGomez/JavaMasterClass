package S20.l363;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost(); // Adress of the host of the server
            DatagramSocket datagramSocket = new DatagramSocket();  // The socket
            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter string to be echoed");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes(); // creates a binary file
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, address, 5000); // create a packet to send
                datagramSocket.send(datagramPacket); // send it

                buffer = new byte[50];
                datagramPacket = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(datagramPacket);
                System.out.println("Text received: "+ new String(buffer, 0, buffer.length));

            } while (!echoString.equals("exit"));
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
