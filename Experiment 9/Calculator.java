import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        String buttons[] = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0","C","=","+"
        };

        final double[] num1 = {0};
        final String[] operator = {""};

        for (String b : buttons) {
            JButton btn = new JButton(b);
            panel.add(btn);

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = btn.getText();

                    if (text.matches("[0-9]")) {
                        textField.setText(textField.getText() + text);
                    }
                    else if (text.equals("C")) {
                        textField.setText("");
                    }
                    else if (text.equals("=")) {
                        double num2 = Double.parseDouble(textField.getText());
                        double result = 0;

                        if (operator[0].equals("+")) result = num1[0] + num2;
                        if (operator[0].equals("-")) result = num1[0] - num2;
                        if (operator[0].equals("*")) result = num1[0] * num2;
                        if (operator[0].equals("/")) result = num1[0] / num2;

                        textField.setText(String.valueOf(result));
                    }
                    else {
                        num1[0] = Double.parseDouble(textField.getText());
                        operator[0] = text;
                        textField.setText("");
                    }
                }
            });
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}