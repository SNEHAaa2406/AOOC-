import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageCombo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Image Viewer");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String images[] = {"img1.png", "img2.png", "img3.png"};

        JComboBox<String> combo = new JComboBox<>(images);
        JLabel label = new JLabel();

        combo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setIcon(new ImageIcon((String) combo.getSelectedItem()));
                }
            }
        });

        frame.add(combo);
        frame.add(label);

        frame.setVisible(true);
    }
}