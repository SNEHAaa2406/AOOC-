import javax.swing.*;
import java.awt.event.*;

public class MouseCoordinates {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Mouse Coordinates");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Move mouse...", JLabel.CENTER);
        frame.add(label);

        frame.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                label.setText("X: " + e.getX() + "  Y: " + e.getY());
            }
        });

        frame.setVisible(true);
    }
}