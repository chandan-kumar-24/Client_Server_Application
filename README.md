# Client_Server_Application

This repository contains Java code for a simple client-server application using socket programming.
The client and server communicate through sockets to send and receive messages.

### Prerequisites
- Java Development Kit (JDK) installed on your system.

### Running the Server

1. Compile the server code:
    ```sh
    javac javaProject/Client_Server/Server.java
    ```
2. Run the server:
    ```sh
    java javaProject.Client_Server.Server
    ```

### Running the Client

1. Compile the client code:
    ```sh
    javac javaProject/Client_Server/Client.java
    ```
2. Run the client:
    ```sh
    java javaProject.Client_Server.Client
    ```

### How It Works

- The **Server** listens on a specified port for incoming connections. Once a client connects, it reads messages sent by the client until "Over" is received.
- The **Client** connects to the server using the server's IP address and port. It reads input from the terminal and sends messages to the server until "Over" is input.

### Code Structure

- **Client.java**: Contains the client-side implementation.
- **Server.java**: Contains the server-side implementation.

### Usage

1. Start the server first, as it will be waiting for client connections.
2. Start the client and enter messages. The client will send these messages to the server.
3. The server will print the messages received from the client.
4. Type "Over" in the client terminal to end the communication and close the connection.

### Example

```sh
# Start the server
java javaProject.Client_Server.Server

# In another terminal, start the client
java javaProject.Client_Server.Client
