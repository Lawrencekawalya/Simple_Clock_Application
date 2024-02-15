package clock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.startClock();
    }

    public void startClock() {
        // Create and start the background updating thread
        Thread backgroundThread = new Thread(this::updateTime);
        backgroundThread.setPriority(Thread.MIN_PRIORITY); // Set lower priority for background updating thread
        backgroundThread.start();

        // Create and start the clock display thread
        Thread displayThread = new Thread(this::displayTime);
        displayThread.setPriority(Thread.MAX_PRIORITY); // Set higher priority for clock display thread
        displayThread.start();
    }

    private void updateTime() {
        while (true) {
            // Simulate background updating tasks
            try {
                Thread.sleep(1000); // Sleep for 1 second to simulate background updates
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void displayTime() {
        while (true) {
            // Display the current time and date
            System.out.println(dateFormat.format(new Date()));

            // Sleep for 1 second to control the display frequency
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
