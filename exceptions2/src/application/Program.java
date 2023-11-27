package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessExceptions;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the account data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: $ ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: $ ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);

		System.out.print("Enter the amount for withdraw: ");

		try {
			acc.withdraw(sc.nextDouble());
			System.out.println("New balance: $ " + acc.getBalance());
		} catch (BusinessExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

		sc.close();

	}
}
