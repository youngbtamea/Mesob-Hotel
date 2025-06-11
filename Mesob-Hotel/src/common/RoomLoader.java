package common;

import java.io.File;
import java.util.Scanner;

public class RoomLoader {

    protected String[][] loadRoomsFromFile(String filename) {
        String[][] rooms = new String[100][5]; // [roomNumber, type, price, status, checkInTime]
        int count = 0;

        try {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("No room data found.");
                return new String[0][0]; // return empty array if file not found
            }

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine() && count < 100) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                for (int i = 0; i < Math.min(parts.length, 5); i++) {
                    rooms[count][i] = parts[i];
                }

                // Fill missing columns with defaults
                if (parts.length < 4) rooms[count][3] = "Available";
                if (parts.length < 5) rooms[count][4] = "None";

                count++;
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Resize array to actual count
        String[][] result = new String[count][5];
        for (int i = 0; i < count; i++) {
            result[i] = rooms[i];
        }

        return result;
    }
}
