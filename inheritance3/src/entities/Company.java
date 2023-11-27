package entities;

public class Company extends TaxPayer {

	private int numEmployees;

	public Company(String name, double anualIncome, int numEmployees) {
		super(name, anualIncome);
		this.numEmployees = numEmployees;
	}

	public int getNumEmployees() {
		return numEmployees;
	}

	public void setNumEmployees(int numEmployees) {
		this.numEmployees = numEmployees;
	}
	
	@Override
	public double tax() {
		if (numEmployees > 10) {
			return super.getAnualIncome() * 0.14;
		} else {
			return super.getAnualIncome() * 0.16;
		}
	}

}


