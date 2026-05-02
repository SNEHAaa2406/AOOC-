import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Counter");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        final int[] count = { 0 };

        JLabel label = new JLabel("Counter:");

        JTextField textField = new JTextField("0", 10);
        textField.setEditable(false);

        JButton upButton = new JButton("Count Up");
        JButton downButton = new JButton("Count Down");
        JButton resetButton = new JButton("Reset");

        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count[0]++;
                textField.setText(String.valueOf(count[0]));
            }
        });

        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count[0]--;
                textField.setText(String.valueOf(count[0]));
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count[0] = 0;
                textField.setText(String.valueOf(count[0]));
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(upButton);
        frame.add(downButton);
        frame.add(resetButton);

        frame.setVisible(true);
    }
}