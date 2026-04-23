import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BallPanel extends JPanel implements Runnable, MouseListener {

    int x = 50, y = 50;
    int dx = 2, dy = 2; // direction
    Thread t;

    public BallPanel() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 30, 30);
    }

    public void run() {
        while (true) {
            x += dx;
            y += dy;

            // Bounce logic
            if (x <= 0 || x >= getWidth() - 30) {
                dx = -dx;
            }
            if (y <= 0 || y >= getHeight() - 30) {
                dy = -dy;
            }

            repaint();

            try {
                Thread.sleep(10); // smooth movement
            } catch (Exception e) {}
        }
    }

    public void mousePressed(MouseEvent e) {
        if (t == null) {
            t = new Thread(this); // Runnable used here
            t.start();
        }
    }

    // unused methods
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

public class BallApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BallPanel panel = new BallPanel();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}