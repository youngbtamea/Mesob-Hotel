package customer;

import common.RoomLoader;

public class AvailableRooms extends RoomLoader {

    public AvailableRooms() {
        String[][] rooms = loadRoomsFromFile("roomsinfo.txt");
        boolean foundAvailable = false;

        System.out.println("===== Available Rooms =====");
        System.out.printf("%-12s %-15s %-10s\n", "Room No", "Room Type", "Price");

        for (String[] room : rooms) {
            if (room[3].equalsIgnoreCase("Available")) {
                System.out.printf("%-12s %-15s %-10s\n", room[0], room[1], room[2]);
                foundAvailable = true;
            }
        }

        if (!foundAvailable) {
            System.out.println("No available rooms at the moment.");
        }

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
//        new Customer_Home();
    }
}
