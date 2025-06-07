
package customer;

public class Customer {
    int choice;
   protected void customer_account(){
       System.out.println("1. LogIn \n2. Signup");
       switch (choice){
           case 1:
               //call the login class
               break;
           case 2:
               Customer_signup ss = new Customer_signup();
               break;
           default:
               System.out.println("Invalid input!!!");
               customer_account();
       }
       
   }
   
}
