/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.userregistrationlogin;

/**
 *
 * @author ttsim
 */
import java.util.Scanner;

public class UserRegistrationLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Registration
        System.out.println("Enter your First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Create Username:");
        String username = scanner.nextLine();

        System.out.println("Create Password:");
        String password = scanner.nextLine();

        System.out.println("Enter South African phone number with international code (e.g., +27831234567):");
        String phone = scanner.nextLine();

        Login login = new Login(firstName, lastName, username, password, phone);
        String regMessage = login.registerUser();
        System.out.println(regMessage);

        if (regMessage.equals("Registration successful.")) {
            // Login phase
            System.out.println("\nPlease log in:");

            System.out.print("Enter Username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Enter Password: ");
            String inputPassword = scanner.nextLine();

            boolean isLoggedIn = login.loginUser(inputUsername, inputPassword);
            System.out.println(login.returnLoginStatus(isLoggedIn));
        }

        scanner.close();
    }
}

