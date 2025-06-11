package customer;

import common.SignUpable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Customer_signup implements SignUpable {
    private String email;
    private String username;
    private String password;
    private String password2;

    public Customer_signup() {
        signUp();
    }

    @Override
    public void signUp() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Customer Signup =====");

        System.out.print("Enter Email: ");
        email = sc.nextLine();

        System.out.print("Enter Username: ");
        username = sc.nextLine();

        while (true) {
            System.out.print("Enter Password: ");
            password = sc.nextLine();

            System.out.print("Confirm Password: ");
            password2 = sc.nextLine();

            if (password.equals(password2)) {
                break;
            } else {
                System.out.println("Passwords do not match! Try again.");
                new Customer().customer_account();
                return; // stop execution after redirecting
            }
        }

        if (saveToFile()) {
            System.out.println("Signup successful! Account created.");
            new Customer_login();
        } else {
            System.out.println("Signup failed. Try again.");
            new Customer().customer_account();
        }

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
    }

    @Override
    public boolean saveToFile() {
        try {
            FileWriter writer = new FileWriter("customers-credentials.txt", true);
            writer.write(email + "," + username + "," + password + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
            return false;
        }
    }
}
