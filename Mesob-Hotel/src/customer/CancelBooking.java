package customer;

import java.io.*;
import java.util.*;

public class CancelBooking {
    private static final String QUEUE_FILE = "booking_queue.txt";

    public CancelBooking() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Room Number to cancel booking: ");
        String cancelRoomNumber = sc.nextLine();

        List<String> updatedBookings = new ArrayList<>();
        boolean found = false;

        try {
            File file = new File(QUEUE_FILE);
            if (!file.exists()) {
                System.out.println("No bookings found.");
                return;
            }

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length >= 1 && parts[0].equals(cancelRoomNumber)) {
                    found = true; // skip this line to "delete" it
                } else {
                    updatedBookings.add(line);
                }
            }
            fileScanner.close();

            // Rewrite the file with updated bookings
            FileWriter writer = new FileWriter(QUEUE_FILE, false); // overwrite mode
            for (String booking : updatedBookings) {
                writer.write(booking + "\n");
            }
            writer.close();

            if (found) {
                System.out.println("✅ Booking for Room " + cancelRoomNumber + " has been cancelled.");
            } else {
                System.out.println("❌ No booking found for Room " + cancelRoomNumber + ".");
            }

        } catch (IOException e) {
            System.out.println("Error processing cancellation: " + e.getMessage());
        }
    }
}
