package admin;

import java.io.*;
import java.util.Scanner;

public class EditRooms {

    public EditRooms() {
        Scanner sc = new Scanner(System.in);
        String[][] rooms = new String[100][3]; // roomNumber, type, price
        int count = 0;

        // Load rooms into array
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
                if (parts.length == 3) {
                    rooms[count][0] = parts[0]; // room number
                    rooms[count][1] = parts[1]; // type
                    rooms[count][2] = parts[2]; // price
                    count++;
                }
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Display rooms
        System.out.println("\n===== Current Room List =====");
        for (int i = 0; i < count; i++) {
            System.out.println("Room Number: " + rooms[i][0] +
                               ", Type: " + rooms[i][1] +
                               ", Price: " + rooms[i][2]);
        }

        // Ask for room to edit
        System.out.print("\nEnter the Room Number you want to edit: ");
        String target = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (rooms[i][0].equals(target)) {
                found = true;

                System.out.print("Enter new Room Number: ");
                rooms[i][0] = sc.nextLine();

                System.out.print("Enter new Room Type: ");
                rooms[i][1] = sc.nextLine();

                System.out.print("Enter new Room Price: ");
                rooms[i][2] = sc.nextLine();

                break;
            }
        }

        if (!found) {
            System.out.println("Room not found!");
            return;
        }

        // Save back to file
        try {
            FileWriter writer = new FileWriter("roomsinfo.txt", false);
            for (int i = 0; i < count; i++) {
                writer.write(rooms[i][0] + "," + rooms[i][1] + "," + rooms[i][2] + "\n");
            }
            writer.close();
            System.out.println("Room updated successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

