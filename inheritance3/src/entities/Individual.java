package entities;

public class Individual extends TaxPayer {

	private double healthExpenditures;

	public Individual(String name, double anualIncome, double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(float healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override 
	public double tax() {
		double valor = 0;
		if (super.getAnualIncome() < 20000) {
			valor = super.getAnualIncome() * 0.15;
		} else {
			valor = super.getAnualIncome() * 0.25;
		}
		if (healthExpenditures > 0) {
			valor -= healthExpenditures * 0.5;
		} 
		return valor;
	}
	
}

