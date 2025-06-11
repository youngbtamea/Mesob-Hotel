
package customer;
import java.util.Scanner;

public class Customer {
    int choice;
    Scanner s = new Scanner(System.in);
   public void customer_account(){
       
       System.out.println("1. LogIn \n2. Signup");
       System.out.println("Enter your choice: ");
       choice = s.nextInt();
       switch (choice){
           case 1:
               new Customer_login();
               System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
               break;
           case 2:
               Customer_signup ss = new Customer_signup();
               System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
               break;
           default:
               System.out.println("Invalid input!!!");
               customer_account();
               
       }
       
   }
   
}
