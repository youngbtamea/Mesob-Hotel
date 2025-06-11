package admin;

import java.io.*;
import java.util.Scanner;

public class CancelReserve {

    public CancelReserve() {
        Scanner sc = new Scanner(System.in);
        String[][] rooms = new String[100][5]; // roomNumber, type, price, status, checkInTime
        int count = 0;

        // Step 1: Load rooms from file
        try {
            File file = new File("roomsinfo.txt");
            if (!file.exists()) {
                System.out.println("No room data found.");
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
                    rooms[count][4] = parts[4]; // check-in time
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

        // Step 2: Ask for room number to cancel reservation
        System.out.print("Enter Room Number to Cancel Reservation: ");
        String roomToCancel = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (rooms[i][0].equals(roomToCancel)) {
                found = true;
                if (!rooms[i][3].equalsIgnoreCase("Reserved")) {
                    System.out.println("Room is not reserved.");
                    return;
                }

                // Step 3: Cancel reservation
                rooms[i][3] = "Available";
                rooms[i][4] = "None";
                System.out.println("Reservation canceled successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Room not found.");
            return;
        }

        // Step 4: Save changes
        try {
            FileWriter writer = new FileWriter("roomsinfo.txt", false);
            for (int i = 0; i < count; i++) {
                writer.write(rooms[i][0] + "," + rooms[i][1] + "," + rooms[i][2] + "," +
                             rooms[i][3] + "," + rooms[i][4] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

