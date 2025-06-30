package javaProject.Client_Server;

import java.io.*;
import java.net.*;

public class Server {
    private Socket socket = null; // Socket initialzed
    private ServerSocket server = null;
    private DataInputStream in = null; // input Stream initialised

    // constructor - parameter - port
    public Server(int port) {
        // server started and waiting for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept(); // Connection accepted
            System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); // User input - message client

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    @SuppressWarnings("unused")
    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}
