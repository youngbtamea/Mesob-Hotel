
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
                return;
            }

            Scanner fileScanner = new Scanner(file);
            boolean foundAvailable = false;

            System.out.println("===== Available Rooms =====");
            System.out.printf("%-15s %-10s\n", "Room Type", "Price");

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length >= 5) {
                    String status = parts[3];
                    if (status.equalsIgnoreCase("Available")) {
                        String type = parts[1];
                        String price = parts[2];
                        System.out.printf("%-15s %-10s\n", type, price);
                        foundAvailable = true;
                    }
                }
            }

            fileScanner.close();

            if (!foundAvailable) {
                System.out.println("No available rooms at the moment.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

