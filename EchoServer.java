package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        new EchoServer().start();
    }

    private void start() {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Waiting connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection is successful!");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            Thread inputThread = null;

            inputThread = runInputThread(in);

        } catch (IOException e) {
            System.out.println("Port is already occupied");
            e.printStackTrace();
        }
    }

    private Thread runInputThread(DataInputStream in) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String message = in.readUTF();
                        System.out.println("Message from client: " + message);
                        if (message.equals("/exit")) {
                            break;
                        }
                    } catch (IOException e) {
                        System.out.println("Connection was closed");
                        break;
                    }
                }
            }
        });
        thread.start();
        return thread;
    }
}
