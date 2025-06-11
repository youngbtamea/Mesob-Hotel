package customer;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Booking {
    private static final String ROOM_FILE = "roomsinfo.txt";
    private static final String QUEUE_FILE = "booking_queue.txt";
    private Queue<String> bookingQueue = new LinkedList<>();

    public Booking() {
        Scanner sc = new Scanner(System.in);

        // Show available rooms
        new AvailableRooms();

        // Ask user to book
        System.out.print("Enter Room Number you want to reserve: ");
        String roomNumber = sc.nextLine();

        System.out.print("Enter Your Full Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Your Phone Number: ");
        String phone = sc.nextLine();

        // Add to queue
        String bookingInfo = roomNumber + "," + name + "," + phone;
        bookingQueue.add(bookingInfo);

        // Save to file
        saveBookingToFile(bookingInfo);

        System.out.println("✅ Your booking has been added to the queue.");
    }

    private void saveBookingToFile(String bookingInfo) {
        try {
            FileWriter writer = new FileWriter(QUEUE_FILE, true); // append mode
            writer.write(bookingInfo + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }
}
