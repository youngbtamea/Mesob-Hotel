package admin;

import java.io.*;
import java.util.Scanner;

public class ReserveRoom {

    public ReserveRoom() {
        Scanner sc = new Scanner(System.in);
        String[][] rooms = new String[100][5]; // roomNumber, type, price, status, checkInTime
        int count = 0;

        // Step 1: Load existing rooms
        try {
            File file = new File("roomsinfo.txt");
            if (!file.exists()) {
                System.out.println("No room data found.");
                new Admin_home();
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                return;
            }

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                rooms[count][0] = parts[0]; // roomNumber
                rooms[count][1] = parts[1]; // type
                rooms[count][2] = parts[2]; // price

                if (parts.length >= 5) {
                    rooms[count][3] = parts[3]; // status
                    rooms[count][4] = parts[4]; // check-in
                } else {
                    rooms[count][3] = "Available";
                    rooms[count][4] = "None";
                }

                count++;
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Step 2: Display rooms
        System.out.println("\n===== Room List =====");
        for (int i = 0; i < count; i++) {
            System.out.println("Room: " + rooms[i][0] +
                               ", Type: " + rooms[i][1] +
                               ", Price: " + rooms[i][2] +
                               ", Status: " + rooms[i][3] +
                               ", Check-in: " + rooms[i][4]);
        }

        // Step 3: Ask admin to reserve a room
        System.out.print("\nEnter Room Number to Reserve: ");
        String target = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (rooms[i][0].equals(target)) {
                found = true;
                if (rooms[i][3].equalsIgnoreCase("Reserved")) {
                    System.out.println("Room is already reserved.");
                    new Admin_home();
                    System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                    return;
                }

                // Step 4: Reserve
                rooms[i][3] = "Reserved";

                System.out.print("Enter Check-in Time (e.g., 2025-06-07 10:00AM): ");
                rooms[i][4] = sc.nextLine();

                break;
            }
        }

        if (!found) {
            System.out.println("Room not found.");
            new Admin_home();
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            return;
           
        }

        // Step 5: Save updated data
        try {
            FileWriter writer = new FileWriter("roomsinfo.txt", false);
            for (int i = 0; i < count; i++) {
                writer.write(rooms[i][0] + "," + rooms[i][1] + "," + rooms[i][2] + "," +
                             rooms[i][3] + "," + rooms[i][4] + "\n");
            }
            writer.close();
            System.out.println("Room reserved successfully!");
            new Admin_home();
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
