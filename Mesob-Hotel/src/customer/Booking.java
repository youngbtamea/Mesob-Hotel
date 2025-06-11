package customer;
import admin.BookingQueue;

import java.util.Scanner;

public class Booking {
    public Booking() {
        Scanner sc = new Scanner(System.in);
        BookingQueue queue = new BookingQueue();

        new AvailableRooms();
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-B-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");

        System.out.print("Enter Room Number you want to reserve: ");
        String roomNumber = sc.nextLine();

        System.out.print("Enter Your Full Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Your Phone Number: ");
        String phone = sc.nextLine();

        String bookingInfo = roomNumber + "," + name + "," + phone;
        queue.enqueue(bookingInfo);
    }
}
