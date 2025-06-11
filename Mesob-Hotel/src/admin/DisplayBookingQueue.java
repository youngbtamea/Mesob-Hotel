package admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayBookingQueue {

    String queueFile = "booking_queue.txt";

    public void play() {
        System.out.println("===== Booking Queue =====");

        try (BufferedReader reader = new BufferedReader(new FileReader(queueFile))) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(count + ". " + line);
                count++;
            }
            

            if (count == 1) {
                System.out.println("The queue is empty.");
                new Admin_home();
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }
            new Admin_home();
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        } 
        
        catch (IOException e) {
            System.out.println("Error reading booking queue: " + e.getMessage());
            new Admin_home();
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        }
    }
}
