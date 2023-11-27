package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
		public static void main(String[] args) {
			
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			System.out.println("Enter contract data:");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Date (dd/MM/yyyy): ");
			String date = sc.next();
			System.out.print("Contract value: ");
			double totalValue = sc.nextDouble();
			System.out.print("Number of installments: ");
			int n = sc.nextInt();
			
			Contract contract = new Contract(number, LocalDate.parse(date, dtf), totalValue);
			ContractService cs = new ContractService(new PaypalService());
			
			cs.processContract(contract, n);
			
			System.out.println("Installments: ");
			
			for (Installment installment : contract.getInstallments()) {
				System.out.println(dtf.format(installment.getDueDate()) + " - " + String.format("%.2f", installment.getAmount()));
			}
			
			sc.close();
		}
}

