package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exception.AccountException;

public class Main {
    public static void main(String[] args) {


        // Instantiating Scanner object and Locale
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        // Printing message to the user
        System.out.println("Enter account data");
        System.out.println("Number: ");
        int number = sc.nextInt();
        System.out.println("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.println("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.println("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        // Instantiating Account object
        Account acc = new Account(number, balance, holder, withdrawLimit);

        // Withdraw operation
        System.out.println("Enter amount for withdraw: ");
        double amount = sc.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));

        } catch (AccountException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }

        // Closing Scanner object
        sc.close();
    }
}