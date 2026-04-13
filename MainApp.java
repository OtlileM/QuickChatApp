package com.myapp.quickchat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Shiko
 */
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        Message[] sentMessages = new Message[100];
        Message[] storedMessages = new Message[100];
        Message[] disregardedMessages = new Message[100];

        int sentCount = 0;
        int storedCount = 0;
        int disregardedCount = 0;

        System.out.println("=== Register User ===");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone (+27...): ");
        String cell = scanner.nextLine();

        String registerMessage = login.registerUser(username, password, cell);
        System.out.println(registerMessage);

        System.out.println("\n=== Login ===");

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPass = scanner.nextLine();

        boolean success = login.loginUser(enteredUsername, loginPass);
        System.out.println(login.returnLoginStatus(success));

        if (success) {

            int choice = 0;

            while (choice != 4) {

                System.out.println("\n=== MENU ===");
                System.out.println("1. Send Messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Stored Messages");
                System.out.println("4. Quit");

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                    continue;
                }

                switch (choice) {

                    case 1:
                        System.out.print("Enter recipient number (+27...): ");
                        String recipient = scanner.nextLine();

                        System.out.print("Enter message: ");
                        String msg = scanner.nextLine();

                        Message message = new Message(recipient, msg);

                        if (!message.checkRecipientCell()) {
                            System.out.println("Cell number is incorrectly formatted.");
                            break;
                        }

                        if (!message.checkMessageLength()) {
                            System.out.println("Message exceeds 250 characters by " + (msg.length() - 250));
                            break;
                        }

                        System.out.println("Choose option:");
                        System.out.println("1. Send Message");
                        System.out.println("2. Discard Message");
                        System.out.println("3. Store Message");

                        int option;
                        try {
                            option = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Invalid option.");
                            break;
                        }

                        if (option == 1) {
                            sentMessages[sentCount++] = message;
                            System.out.println("Message successfully sent");
                            System.out.println(message.getMessageDetails());

                        } else if (option == 2) {
                            disregardedMessages[disregardedCount++] = message;
                            System.out.println("Message discarded.");

                        } else if (option == 3) {
                            storedMessages[storedCount++] = message;
                            System.out.println("Message successfully stored");
                        }

                        break;

                    case 2:
                        if (sentCount == 0) {
                            System.out.println("No sent messages.");
                        } else {
                            for (int i = 0; i < sentCount; i++) {
                                System.out.println(sentMessages[i].getMessageDetails());
                            }
                        }
                        break;

case 3:

    if (storedCount == 0) {
        System.out.println("No stored messages.");
        break;
    }

    System.out.println("=== Stored Messages ===");
    for (int i = 0; i < storedCount; i++) {
        if (storedMessages[i] != null) {
            System.out.println("Recipient: " + storedMessages[i].getRecipient());
        }
    }

    String longest = "";
    for (int i = 0; i < storedCount; i++) {
        if (storedMessages[i] != null &&
            storedMessages[i].getMessage().length() > longest.length()) {
            longest = storedMessages[i].getMessage();
        }
    }
    System.out.println("Longest message: " + longest);

    System.out.print("Enter Message ID to search: ");
    String searchID = scanner.nextLine();

    for (int i = 0; i < storedCount; i++) {
        if (storedMessages[i] != null &&
            storedMessages[i].getMessageID().equals(searchID)) {

            System.out.println("Recipient: " + storedMessages[i].getRecipient());
            System.out.println("Message: " + storedMessages[i].getMessage());
        }
    }

    System.out.print("Enter recipient to search: ");
    String searchRecipient = scanner.nextLine();

    boolean found = false;

    for (int i = 0; i < storedCount; i++) {
        if (storedMessages[i] != null &&
            storedMessages[i].getRecipient().equals(searchRecipient)) {

            System.out.println("Stored: " + storedMessages[i].getMessage());
            found = true;
        }
    }

    for (int i = 0; i < sentCount; i++) {
        if (sentMessages[i] != null &&
            sentMessages[i].getRecipient().equals(searchRecipient)) {

            System.out.println("Sent: " + sentMessages[i].getMessage());
            found = true;
        }
    }

    if (!found) {
        System.out.println("No messages found for this recipient.");
    }

    System.out.print("Enter message hash to delete: ");
    String hash = scanner.nextLine();

    for (int i = 0; i < storedCount; i++) {
        if (storedMessages[i] != null &&
            storedMessages[i].getMessageHash().equals(hash)) {

            for (int j = i; j < storedCount - 1; j++) {
                storedMessages[j] = storedMessages[j + 1];
            }

            storedMessages[storedCount - 1] = null;
            storedCount--;

            System.out.println("Message deleted.");
            break;
        }
    }

    System.out.println("=== REPORT ===");
    for (int i = 0; i < storedCount; i++) {
        if (storedMessages[i] != null) {
            System.out.println(storedMessages[i].getMessageDetails());
        }
    }

    break;

                    case 4:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option");
                }
            }
        }

        scanner.close();
    }
}
