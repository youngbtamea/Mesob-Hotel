package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AvailableRooms {

    public AvailableRooms() {
        try {
            File file = new File("roomsinfo.txt");
            if (!file.exists()) {
                System.out.println("No room data found.");
                new Customer_Home();
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                return;
            }

            Scanner fileScanner = new Scanner(file);
            boolean foundAvailable = false;

            System.out.println("===== Available Rooms =====");
            System.out.printf("%-12s %-15s %-10s\n", "Room No", "Room Type", "Price");

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length >= 5) {
                    String status = parts[3];
                    if (status.equalsIgnoreCase("Available")) {
                        String roomNumber = parts[0];
                        String type = parts[1];
                        String price = parts[2];
                        System.out.printf("%-12s %-15s %-10s\n", roomNumber, type, price);
                        foundAvailable = true;
                    }
                }
            }

            fileScanner.close();

            if (!foundAvailable) {
                System.out.println("No available rooms at the moment.");
                new Customer_Home();
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }
            new Customer_Home();
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            new Customer_Home();
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        }
    }
}
