package javaProject.Client_Server;

import java.io.*;
import java.net.*;

public class Client {
    // Initialize socket and input/output streams
    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;

    // Constructor to put IP address and port
    public Client(String address, int port) {
        try {
            // Establish a connection
            socket = new Socket(address, port);
            System.out.println("Connected");

            // Takes input from the terminal
            input = new BufferedReader(new InputStreamReader(System.in));

            // Sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

            String line = "";

            // Keep reading until "Over" is input
            while (!line.equals("Over")) {
                try {
                    line = input.readLine();
                    out.writeUTF(line);
                } catch (IOException i) {
                    System.out.println("I/O Error: " + i.getMessage());
                }
            }
        } catch (UnknownHostException u) {
            System.out.println("Unknown host: " + u.getMessage());
        } catch (IOException i) {
            System.out.println("I/O Error: " + i.getMessage());
        } finally {
            // Close the connection
            try {
                if (input != null)
                    input.close();
                if (out != null)
                    out.close();
                if (socket != null)
                    socket.close();
            } catch (IOException i) {
                System.out.println("Error closing resources: " + i.getMessage());
            }
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
