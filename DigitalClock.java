package com.inernship;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DigitalClock extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        // Set up the frame
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a label to display the time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 50));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.BLACK);
        
        // Set background color
        getContentPane().setBackground(new Color(132, 88, 179));

        // Create a time format
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeFormat.setTimeZone(TimeZone.getDefault());

        // Add the time label to the frame
        add(timeLabel);
    }

    public void startClock() {
        // Create a timer to update the time every second
        Timer timer = new Timer(1000, e -> {
            String time = timeFormat.format(new Date());
            timeLabel.setText(time);
        });
        timer.start();
    }

    public static void main(String[] args) {
        // Create and display the clock
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
            clock.startClock();
        });
    }
}
