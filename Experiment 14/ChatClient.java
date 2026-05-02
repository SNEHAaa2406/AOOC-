import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Scanner keyboard = new Scanner(System.in);

        String message;
        while (true) {
            System.out.print("Client message: ");
            message = keyboard.nextLine();
            output.println(message);

            String reply = input.readLine();
            System.out.println("Server says: " + reply);
        }
    }
}
