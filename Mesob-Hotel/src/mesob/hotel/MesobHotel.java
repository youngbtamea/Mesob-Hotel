
package mesob.hotel;
import java.util.Scanner;
import admin.Admin_login;


public class MesobHotel {
    private static void customer_log_sign(){
        Scanner s = new Scanner(System.in);
        System.out.println("1. Customer Login \n2. Customer Sign Up");
        System.out.println("Enter your choice: ");
        int choice2;
        choice2 = s.nextInt();
        switch(choice2){
            case 1:
                //class called signin
                break;
            case 2:
                //class signup called
                break;
            default:
                System.out.println("Invalid input!!! ");
                break;
        }
        
    }

    public static void main(String[] args) {
        System.out.println("                                         ╔════════════════════════════════════╗\n" +

"                                         ║    WELCOME TO MESOB HOTEL     ║\n" +
"                                         ╚════════════════════════════════════╝");
        System.out.println("\n \n Welcome to our iconic Mesob Hotel, Where comfort meets tradition");
        System.out.println("\nPlease make a choice: ");
        System.out.println("1. Admin \n2. Customer");
        
        int choice;
        
        System.out.print("Enter your choice: ");
        Scanner s = new Scanner(System.in);
        choice = s.nextInt();
        
        switch (choice){
            case 1:
                Admin_login A= new Admin_login();
                A.check_admin_login();
                break;
            case 2:
                customer_log_sign();
                break;
            default:
                System.out.print("Input invalid!!! ");
                
                
        }
       
        
        
        
    }
    
}
