package admin;

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
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        choice3 = sc.nextInt(); 

        switch (choice3) {
            case 1:
                System.out.println("Redirecting to EditRooms...");
                new EditRooms(); 
                break;
            case 2:
                System.out.println("Redirecting to ReserveRoom...");
                new ReserveRoom(); 
                break;
            case 3:
                System.out.println("Redirecting to AddRoom...");
                new AddRooms(); 
                break;
            case 4:
                System.out.println("Redirecting to CancelReserve...");
                new CancelReserve(); 
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                new Admin_home(); 
        }
    }
}
