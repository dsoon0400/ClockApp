package testingGrounds;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock App");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        panel.add(timeLabel, BorderLayout.CENTER);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime time = LocalTime.now();
                String timeText = time.format(DateTimeFormatter.ofPattern(
                    "HH:mm:ss"));
                if (timeText.equals("00:00:00")) {
                    timeLabel.setText("NEW DAY!");
                }
                else {
                    timeLabel.setText(timeText);
                }
            }
        });

        timer.start();
        frame.add(panel);
        frame.setVisible(true);
    }
}
