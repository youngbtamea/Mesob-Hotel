package admin;
import mesob.hotel.MesobHotel;

import java.util.Scanner;

public class Admin_home {
    public Admin_home() {
        Scanner sc = new Scanner(System.in);
        int choice3;

        System.out.println("===== Admin Menu =====");
        System.out.println("1. Update Room");
        System.out.println("2. Reserve Room");
        System.out.println("3. Add Room");
        System.out.println("4. Cancel Reservation");
        System.out.println("5. See Booked Rooms");
        System.out.println("6. Display Rooms");
        System.out.println("7. Exit");

        System.out.print("Enter your choice: ");
        choice3 = sc.nextInt(); 

        switch (choice3) {
            case 1:
                System.out.println("Redirecting to EditRooms...");
                new EditRooms(); 
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                break;
            case 2:
                System.out.println("Redirecting to ReserveRoom...");
                ReserveRoom rr = new ReserveRoom();
                rr.reserve();
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                break;
            case 3:
                System.out.println("Redirecting to AddRoom...");
                new AddRooms(); 
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                break;
            case 4:
                System.out.println("Redirecting to CancelReserve...");
                new CancelReserve(); 
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                break;
            case 5:
                System.out.println("Redirect to See Booked rooms");
                DisplayBookingQueue queueDisplay = new DisplayBookingQueue();
                queueDisplay.play();
                break;
            case 6:
                System.out.println("Redirecting to Display Rooms");
                new DisplayRooms();
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                break;
            case 7:
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_- BYE:( _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                new Admin_home(); 
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        }
    }
}
