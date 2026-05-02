import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Scanner keyboard = new Scanner(System.in);

        String message;
        while (true) {
            message = input.readLine();
            System.out.println("Client says: " + message);

            System.out.print("Server reply: ");
            String reply = keyboard.nextLine();
            output.println(reply);
        }
    }
}