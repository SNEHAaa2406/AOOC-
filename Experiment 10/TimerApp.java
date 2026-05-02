import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Timer");
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("0");
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        final int[] count = {0};

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count[0]++;
                label.setText(String.valueOf(count[0]));
            }
        });

        start.addActionListener(e -> timer.start());
        stop.addActionListener(e -> timer.stop());

        frame.add(label);
        frame.add(start);
        frame.add(stop);

        frame.setVisible(true);
    }
}