package S20.l363;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        try{
            DatagramSocket datagramSocket= new DatagramSocket(5000);
            while(true){
                byte[] buffer = new byte[50];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(datagramPacket);
                System.out.println("Text received: "+ new String(buffer, 0, buffer.length));

                String returnString = "echo "+ new String(buffer, 0, buffer.length);
                byte[] buffer2 = returnString.getBytes(); // creates a binary file
                InetAddress address = datagramPacket.getAddress();
                int port = datagramPacket.getPort();
                DatagramPacket packet = new DatagramPacket(buffer2, buffer2.length, address, port); // create a packet to send
                datagramSocket.send(packet); // send it

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
