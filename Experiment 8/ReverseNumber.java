import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReverseNumber {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Reverse Number");
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField input = new JTextField(10);
        JTextField output = new JTextField(10);
        output.setEditable(false);

        JButton button = new JButton("Reverse");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num = input.getText();
                String reversed = "";

                for (int i = num.length() - 1; i >= 0; i--) {
                    reversed += num.charAt(i);
                }

                output.setText(reversed);
            }
        });

        frame.add(new JLabel("Enter Number:"));
        frame.add(input);
        frame.add(button);
        frame.add(new JLabel("Reversed:"));
        frame.add(output);

        frame.setVisible(true);
    }
}