// Import necessary libraries
package clock;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

// Class representing the Clock GUI
public class Clock_GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private JLabel timeLabel;
    private JLabel dateLabel;

    // Constructor for the Clock GUI
    public Clock_GUI() {
    	setForeground(new Color(255, 0, 0));
    	setBackground(new Color(255, 0, 0));
        // Set background color, icon, and title
        getContentPane().setForeground(new Color(0, 0, 255));
        getContentPane().setBackground(new Color(192, 192, 192));
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\android-alarm-clock.png"));
        setTitle("Clock Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents(); // Initialize GUI components
        startClock(); // Start the clock
    }

    // Method to initialize GUI components
    private void initComponents() {
        // Set layout with two rows (one for time, one for date)
        getContentPane().setLayout(new GridLayout(2, 1));

        // Time Section
        JPanel timePanel = new JPanel();
        timePanel.setBackground(new Color(255, 255, 255));
        timePanel.setForeground(new Color(255, 255, 255));
        // Set titled border with blue line border and title "Time"
        timePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 8, true),
                "Time", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        FlowLayout fl_timePanel = new FlowLayout();
        timePanel.setLayout(fl_timePanel); // Align the label to the center
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Elephant", Font.BOLD, 20));
        timeLabel.setVerticalAlignment(SwingConstants.TOP);
        timeLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\clock (1) (1).png"));
        timeLabel.setForeground(new Color(0, 0, 255));
        timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        timePanel.add(timeLabel);
        getContentPane().add(timePanel);

        // Date Section
        JPanel datePanel = new JPanel();
        // Set titled border with blue line border and title "Date"
        datePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255),
                8, true), "Date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        datePanel.setLayout(new FlowLayout()); // Align the label to the center
        dateLabel = new JLabel();
        dateLabel.setForeground(new Color(0, 0, 255));
        dateLabel.setFont(new Font("Elephant", Font.BOLD, 25));
        dateLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\calendar.png"));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        datePanel.add(dateLabel);
        getContentPane().add(datePanel);

        // Set up a timer to update the time and date labels every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeAndDate();
            }
        });
        timer.start();

        setSize(300, 200);
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }

    // Method to update the time and date labels
    private void updateTimeAndDate() {
        timeLabel.setText(timeFormat.format(new Date()));
        dateLabel.setText(dateFormat.format(new Date()));
    }

    // Method to start the clock
    private void startClock() {
        // You can add any additional initialization logic here
    }

    // Main method to launch the Clock GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clock_GUI().setVisible(true);
            }
        });
    }
}
