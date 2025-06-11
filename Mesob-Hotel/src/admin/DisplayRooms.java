package admin;

import common.RoomLoader;

public class DisplayRooms extends RoomLoader {

    public DisplayRooms() {
        String[][] rooms = loadRoomsFromFile("roomsinfo.txt");

        System.out.println("\n===== Room List =====");
        for (String[] room : rooms) {
            String number = room[0];
            String type = room[1];
            String price = room[2];
            String status = room[3];
            String checkIn = room[4];

            System.out.println("Room: " + number +
                               ", Type: " + type +
                               ", Price: " + price +
                               ", Status: " + status +
                               ", Check-in: " + checkIn);
        }

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        new Admin_home();
    }
}
