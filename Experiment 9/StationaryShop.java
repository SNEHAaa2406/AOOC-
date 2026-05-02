import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StationaryShop {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Stationary Purchase System");
        frame.setSize(350, 250);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCheckBox notebook = new JCheckBox("Notebook @ 50");
        JCheckBox pen = new JCheckBox("Pen @ 30");
        JCheckBox pencil = new JCheckBox("Pencil @ 10");

        JButton order = new JButton("Order");

        order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int total = 0;
                String message = "";

                if (notebook.isSelected()) {
                    String qty = JOptionPane.showInputDialog("Enter quantity for Notebook");
                    int q = Integer.parseInt(qty);
                    int cost = q * 50;
                    total += cost;
                    message += "Notebook Quantity: " + q + " Total: " + cost + "\n";
                }

                if (pen.isSelected()) {
                    String qty = JOptionPane.showInputDialog("Enter quantity for Pen");
                    int q = Integer.parseInt(qty);
                    int cost = q * 30;
                    total += cost;
                    message += "Pen Quantity: " + q + " Total: " + cost + "\n";
                }

                if (pencil.isSelected()) {
                    String qty = JOptionPane.showInputDialog("Enter quantity for Pencil");
                    int q = Integer.parseInt(qty);
                    int cost = q * 10;
                    total += cost;
                    message += "Pencil Quantity: " + q + " Total: " + cost + "\n";
                }

                message += "\nTotal: " + total;

                JOptionPane.showMessageDialog(frame, message);
                JOptionPane.showMessageDialog(frame, "Successfully Ordered");
            }
        });

        frame.add(notebook);
        frame.add(pen);
        frame.add(pencil);
        frame.add(order);

        frame.setVisible(true);
    }
}