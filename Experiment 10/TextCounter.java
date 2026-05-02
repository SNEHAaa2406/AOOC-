import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextCounter {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Text Counter");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea area = new JTextArea(10, 25);
        JLabel label = new JLabel("Chars: 0 Words: 0");

        area.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = area.getText();
                int chars = text.length();
                int words = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
                label.setText("Chars: " + chars + " Words: " + words);
            }
        });

        frame.add(new JScrollPane(area));
        frame.add(label);

        frame.setVisible(true);
    }
}