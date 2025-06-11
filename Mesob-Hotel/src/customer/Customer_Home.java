
package customer;
import java.util.Scanner;


public class Customer_Home {
    Scanner s = new Scanner(System.in);
    Customer_Home(){
        System.out.println("1. Available Rooms \n2. Book room \n3. Cancle Booking");
        int choice4;
        choice4 = s.nextInt();
        switch(choice4){
            case 1:
                System.out.println("redirecting to availablerooms ");
                new AvailableRooms();
                break;
            case 2:
                System.out.println("redirecting to book room ");
                new Booking();
                break;
            case 3:
                System.out.println("redirecting to Cancle Booking ");
                new CancelBooking();
                break;
            default:
                System.out.println("unable to reach...! ");
        }
        
    }
    
}
