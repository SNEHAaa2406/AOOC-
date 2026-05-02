import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SumClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 6000);
        System.out.println("Connected to Sum Server!");

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = keyboard.nextInt();

        System.out.print("Enter second number: ");
        int num2 = keyboard.nextInt();

        output.println(num1);
        output.println(num2);

        String result = input.readLine();
        System.out.println("Server says: " + result);

        socket.close();
    }
}