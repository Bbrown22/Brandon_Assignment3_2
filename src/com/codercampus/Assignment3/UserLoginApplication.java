package com.codercampus.Assignment3;

import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean loggedIn = false;

        while (!loggedIn && attempts < 5) {
            System.out.print("Enter your email: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            User currentUser = userService.findUser(username, password);
            if (currentUser != null) {
                System.out.println("Welcome: " + currentUser.getName());
                loggedIn = true;
            } else {
                System.out.println("Invalid login, please try again.");
                attempts++;
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }

        scanner.close();
    }
}
