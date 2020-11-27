package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HomeClient {

    private final String SERVER_ADDRESS = "localhost";
    private final int SERVER_PORT = 8199;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private Scanner scn = new Scanner(System.in);

    public HomeClient() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            while (true) {
                try {
                    String messageFromServer = in.readUTF();
                    System.out.println("message from Server: " + messageFromServer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void closeConnection() {
        System.out.println("connection closed");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
        System.out.println("to stop conversation type \"stop\"");
        System.out.println("please type your message to server:");

        while (true) {
            String message = scn.nextLine();
            if (message.equalsIgnoreCase("/stop")) {
                closeConnection();
            }
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HomeClient homeClient = new HomeClient();
        homeClient.sendMessage();
    }
}
