import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChanger {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Color Changer");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Choose Color");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(frame, "Select Color", Color.WHITE);
                frame.getContentPane().setBackground(c);
            }
        });

        frame.add(button);

        frame.setVisible(true);
    }
}