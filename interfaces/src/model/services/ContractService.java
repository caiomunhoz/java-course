package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {

		double valuePerMonth = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(valuePerMonth, i);
			double paymentFee = onlinePaymentService.paymentFee(valuePerMonth + interest);
			double amount = paymentFee + interest + valuePerMonth;
			contract.getInstallments().add(new Installment(dueDate, amount));
		}

	}

}


