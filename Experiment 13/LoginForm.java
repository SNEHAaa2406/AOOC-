import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField user = new JTextField(15);
        JPasswordField pass = new JPasswordField(15);

        JButton register = new JButton("Register");
        JButton login = new JButton("Login");

        frame.add(new JLabel("Username:"));
        frame.add(user);
        frame.add(new JLabel("Password:"));
        frame.add(pass);
        frame.add(register);
        frame.add(login);

        register.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/college", "root", "password");

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO users VALUES (?, ?)");

                ps.setString(1, user.getText());
                ps.setString(2, new String(pass.getPassword()));

                ps.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Registered");

                con.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        login.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/college", "root", "password");

                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM users WHERE username=? AND password=?");

                ps.setString(1, user.getText());
                ps.setString(2, new String(pass.getPassword()));

                ResultSet rs = ps.executeQuery();

                if (rs.next())
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                else
                    JOptionPane.showMessageDialog(frame, "Invalid");

                con.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        frame.setVisible(true);
    }
}