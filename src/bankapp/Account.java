package bankapp;

import java.util.Scanner;

public class Account {
	int balance;
	int previousTransaction;
	int customerID;
	String customerName;
	
	Account(String cname, int cid){
		customerName = cname;
		customerID = cid;
	}
	
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if (amount != 0) {
			 balance = balance - amount;
			 previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		 if (previousTransaction > 0) {
			 System.out.println("Deposited: " + previousTransaction);
		 } else if (previousTransaction < 0) {
			 System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		 } else {
			 System.out.println("No transaction occured");
		 }
	}
	
	void calculateInterest(int years) {
		double interestRate = 0.0185;
		double newBalance = balance;
		for (int i = 0; i < years; i++) {
			newBalance = newBalance * interestRate + newBalance;
		}
		System.out.println("Interest rate: " + Math.round((100 * interestRate) * 100.0) / 100.0 + "%");
		System.out.println("After " + years + " years, the new balance is: " + Math.round(newBalance * 100.0) / 100.0);	
	}
	
	void showMenu() {
		char option = '\0';
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("ID: " + customerID);
		System.out.println();
		System.out.println("Choose an option:");
		System.out.println();
		System.out.println("A. Check balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View last transaction");
		System.out.println("E. Calculate interest for X years");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = input.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option){
			case 'A':
				System.out.println("===========================");
				System.out.println("Balance = £" + balance);
				System.out.println("===========================");
				System.out.println();
				break;
			case 'B':
				System.out.println("Enter amount to deposit: ");
				int amount = input.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case 'C':
				System.out.println("Enter amount to withdraw: ");
				int amount2 = input.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			case 'D':
				System.out.println("===========================");
				getPreviousTransaction();
				System.out.println("===========================");
				System.out.println();
				break;
			case 'E':
				System.out.println("Enter how many years of interest are we calculating: ");
				int years = input.nextInt();
				calculateInterest(years);
				break;
			case 'F':
				System.out.println("===========================");
				break;
			default:
				System.out.println("Invalid option, please select A, B, C, D, E or F!");
				break;
			} 
			
		} while (option != 'F');
		System.out.println("Thank you for chosing us!");
		input.close();
	}
}
