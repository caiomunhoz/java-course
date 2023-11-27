package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Product> products = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char productType = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (productType == 'c') {
				products.add(new Product(name, price));
			} else if (productType == 'u') {
				System.out.print("Manufacture date (dd/MM/yyyy): ");
				String date = sc.next();
				products.add(new UsedProduct(name, price, LocalDate.parse(date, dtf)));
			} else if (productType == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			}
		}

		System.out.println("\nPrice tags:");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}

		sc.close();

	}
}


