
package admin;
import java.io.IOException;
import java.util.Scanner;

public class Admin_login {
    protected static final String admin_username = "admin";
    protected static final String admin_password = "admin123";
//    Admin_login(String admin_username, String admin_password){
//        Admin_login.admin_username = admin_username;
//        this.admin_password = admin_password;
//        
//    }
    public void check_admin_login(){
        String user_name;
        String password;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter User Name: ");
        user_name = s.next();
        System.out.println("Enter password: ");
        password = s.next();
        
        if (user_name.equals(admin_username)  && password.equals(admin_password) ){
            System.out.println("Access Granted! ");
            //method called
            
        }else{
            System.out.println("Access Denied!!! UserName or Password incorrect!");
            while(true){
                check_admin_login();
            }
        }
        
        
        
    }
    
}
