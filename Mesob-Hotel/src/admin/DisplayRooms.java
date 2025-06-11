
package admin;


import java.io.File;
import java.util.Scanner;

public class DisplayRooms {

    public DisplayRooms() {
        String[][] rooms = new String[100][5]; // roomNumber, type, price, status, checkInTime
        int count = 0;

        // Load room info from file
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

                rooms[count][0] = parts[0]; // room number
                rooms[count][1] = parts[1]; // type
                rooms[count][2] = parts[2]; // price
                rooms[count][3] = (parts.length >= 4) ? parts[3] : "Available"; // status
                rooms[count][4] = (parts.length >= 5) ? parts[4] : "None";      // check-in

                count++;
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Display rooms
        System.out.println("\n===== Room List =====");
        for (int i = 0; i < count; i++) {
            System.out.println("Room: " + rooms[i][0] +
                               ", Type: " + rooms[i][1] +
                               ", Price: " + rooms[i][2] +
                               ", Status: " + rooms[i][3] +
                               ", Check-in: " + rooms[i][4]);
        }
        new Admin_home();
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
    }
}

