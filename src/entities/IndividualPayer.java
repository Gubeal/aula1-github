package entities;

public class IndividualPayer extends Payer{

	private Double healthExpenditures;
	
	public IndividualPayer(String name, Double income, Double healthExpenditures) {
		super(name, income);
		this.healthExpenditures = healthExpenditures;
	}
		
	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		double tax;
		if (getIncome() < 20000) {
			tax = 0.15;
		} else {
			tax = 0.25;
		}
		
		return (getIncome() * tax) - (getHealthExpenditures() * 0.5);
	}

}
