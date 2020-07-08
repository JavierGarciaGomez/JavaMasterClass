package S20.l359_361;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Main connected");
                BufferedReader input = new BufferedReader
                        (new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String echoString = input.readLine();
                try{
                    Thread.sleep(5000);
                } catch(InterruptedException e){
                    System.out.println("Thread interrupted");
                }
                if(echoString.equals("exit")){
                    break;
                }
                output.println("Echo from server: "+echoString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
