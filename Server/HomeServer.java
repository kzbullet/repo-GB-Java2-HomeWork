package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeServer {

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server is on, waiting for connection...");
            socket = serverSocket.accept();
            System.out.println("Client is connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = in.readUTF();
                if (message.equals("/end")) {
                    break;
                }
                out.writeUTF("From server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
