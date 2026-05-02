import java.io.*;
import java.net.*;

public class SumServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Sum Server started. Waiting...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        int num1 = Integer.parseInt(input.readLine());
        int num2 = Integer.parseInt(input.readLine());
        System.out.println("Received: " + num1 + " and " + num2);

        int sum = num1 + num2;
        output.println("Sum = " + sum);
        System.out.println("Sum sent to client: " + sum);

        socket.close();
        serverSocket.close();
    }
}