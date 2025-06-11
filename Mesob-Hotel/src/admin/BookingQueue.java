
package admin;


import java.io.*;
import java.util.LinkedList;

public class BookingQueue {
    private LinkedList<String> queue = new LinkedList<>();
    private static final String QUEUE_FILE = "booking_queue.txt";

    public BookingQueue() {
        loadFromFile(); // Load existing bookings into queue
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
    }

    public void enqueue(String data) {
        queue.addLast(data);
        saveToFile();
        System.out.println("✅ Booking added to the queue.");
    }

    public String dequeue() {
        if (!queue.isEmpty()) {
            String removed = queue.removeFirst();
            saveToFile();
            return removed;
        } else {
            System.out.println("❌ Queue is empty.");
            return null;
        }
    }

    public String peek() {
        if (!queue.isEmpty()) {
            return queue.getFirst();
        } else {
            System.out.println("❌ Queue is empty.");
            return null;
        }
    }

    public void display() {
        if (queue.isEmpty()) {
            System.out.println("❌ No bookings in the queue.");
        } else {
            System.out.println("📋 Booking Queue:");
            for (String booking : queue) {
                System.out.println(" - " + booking);
            }
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(QUEUE_FILE))) {
            for (String booking : queue) {
                writer.write(booking);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving queue to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(QUEUE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.add(line);
            }
        } catch (IOException e) {
            // File might not exist yet; that's okay
        }
    }
}
