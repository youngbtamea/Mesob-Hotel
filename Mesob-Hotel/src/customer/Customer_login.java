
package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer_login {
    private String username;
    private String password;

    public Customer_login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Customer Login =====");

        System.out.print("Enter Username: ");
        username = sc.nextLine();

        System.out.print("Enter Password: ");
        password = sc.nextLine();

        // Check credentials
        if (validateLogin()) {
            System.out.println("Login successful! Welcome, " + username);
        } else {
            System.out.println("Login failed! Invalid username or password.");
        }
    }

    private boolean validateLogin() {
        try {
            File file = new File("customers-credentials.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); // one line like: email,username,password
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String fileEmail = parts[0];
                    String fileUsername = parts[1];
                    String filePassword = parts[2];

                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true;
                    }
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("User informaion can't find,  Sign up first");
        }

        return false;
    }
}
