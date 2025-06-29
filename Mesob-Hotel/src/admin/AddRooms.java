package admin;

import common.RoomOperations;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddRooms implements RoomOperations {

    public AddRooms() {
        addRoom();
    }

    @Override
    public void addRoom() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Add Room Information =====");

        System.out.print("Enter Room Number: ");
        String roomNumber = sc.nextLine();

        System.out.print("Enter Room Type (e.g., suite, double, single): ");
        String roomType = sc.nextLine();

        System.out.print("Enter Room Price: ");
        double price = 0;
        try {
            price = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid price input! Setting price to 0.0");
        }

        saveRoomToFile(roomNumber, roomType, price);
    }

    private void saveRoomToFile(String roomNumber, String roomType, double price) {
        try {
            FileWriter writer = new FileWriter("roomsinfo.txt", true); // append mode
            writer.write(roomNumber + "," + roomType + "," + price + "\n");
            writer.close();
            System.out.println("Room added successfully!");
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            new Admin_home();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            new Admin_home();
        }
    }
}
