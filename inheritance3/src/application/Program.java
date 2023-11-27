package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;
import entities.Individual;
import entities.Company;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxPayers = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print("Individual or company (i/c)? ");
			char opt = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (opt == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				 taxPayers.add(new Individual(name, anualIncome, healthExpenditures));
			} else if (opt == 'c') {
				System.out.print("Number of employees: ");
				int numEmployees = sc.nextInt();
				 taxPayers.add(new Company(name, anualIncome, numEmployees));
			}
		}

		double sum = 0;
		System.out.println("\nTaxes paid:");
		for (TaxPayer taxPayer :  taxPayers) {
			System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
			sum += taxPayer.tax();
		}

		System.out.print("\nTotal taxes: $ " + String.format("%.2f", sum));

		sc.close();

	}

}
