import javax.swing.*;

class Stopwatch extends JFrame implements Runnable {

    JLabel label;
    JButton start, stop, reset;

    int seconds = 0;
    boolean running = false;
    Thread t;

    public Stopwatch() {
        label = new JLabel("Time: 0 sec");
        start = new JButton("Start");
        stop = new JButton("Stop");
        reset = new JButton("Reset");

        setLayout(null);

        label.setBounds(100, 50, 200, 30);
        start.setBounds(50, 100, 80, 30);
        stop.setBounds(150, 100, 80, 30);
        reset.setBounds(250, 100, 80, 30);

        add(label);
        add(start);
        add(stop);
        add(reset);

        start.addActionListener(e -> {
            if (!running) {
                running = true;
                t = new Thread(this);
                t.start();
            }
        });

        stop.addActionListener(e -> running = false);

        reset.addActionListener(e -> {
            running = false;
            seconds = 0;
            label.setText("Time: 0 sec");
        });

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void run() {
        while (running) {
            seconds++;
            label.setText("Time: " + seconds + " sec");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        new Stopwatch();
    }
}

