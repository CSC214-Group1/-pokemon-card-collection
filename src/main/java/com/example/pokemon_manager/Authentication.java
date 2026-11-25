
package com.example.pokemon_manager;

import java.util.Scanner;

public class Authentication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Existing account credentials
        String savedUsername = "collector";
        String savedPassword = "pokemon123";

        boolean authenticated = false;

        // Keep asking until correct credentials are entered
        while (!authenticated) {

            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.print("Enter password: ");
            String password = input.nextLine();

            // Verify username and password
            if (username.equals(savedUsername) &&
                password.equals(savedPassword)) {

                System.out.println("Access Granted!");
                authenticated = true;

            } else {

                System.out.println("Incorrect username or password. Try again.\n");

            }
        }

        input.close();
    }
}
