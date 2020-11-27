package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HomeServer {

    private final int SERVER_PORT = 8199;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private Scanner scn = new Scanner(System.in);

    public HomeServer() {
        startServer();
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is on, waiting for connection...");
            socket = serverSocket.accept();
            System.out.println("Client is connected.");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String messageFromClient = in.readUTF();
                        System.out.println("message from Client: " + messageFromClient);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
        System.out.println("to stop conversation type \"/stop\"");
        System.out.println("please type your message to client:");

        while (true) {
            String message = scn.nextLine();
            if (message.equalsIgnoreCase("/stop")) {
                break;
            }
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HomeServer homeServer = new HomeServer();
        homeServer.sendMessage();
    }

}
