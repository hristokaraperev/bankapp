package bankapp;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your name and ID");
		System.out.print("Customer Name: ");
		String customerName = input.nextLine();
		System.out.print("Customer ID: ");
		int customerID = input.nextInt();
		
		Account account = new Account(customerName, customerID);
		account.showMenu();
		
		exitProcedure(input, account);
	}
	
	static void exitProcedure(Scanner input, Account account) {
		input.close();
		account = null;
		System.gc();
	}

}
