package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> products = new ArrayList<>();

		System.out.print("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();

		new File(sourceFolderStr + "\\out").mkdir();

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");

				products.add(new Product(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2])));
				line = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFolderStr + "\\out\\summary.csv"))) {
				for (Product product : products) {
					bw.write(product.getName() + "," + product.total());
					bw.newLine();
				}
				
				System.out.println(sourceFolderStr + "\\out\\summary.csv created!");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}
