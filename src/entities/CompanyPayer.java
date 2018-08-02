package entities;

public class CompanyPayer extends Payer{
	private Integer numberEmployees;
	
	public CompanyPayer(String name, Double income, Integer numberEmployees) {
		super(name, income);
		this.numberEmployees = numberEmployees;
	}

	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public Double tax() {
//		double tax = 0.16;
//		if (getNumberEmployees() > 10) {
//			tax = 0.14;
//		}
//		return getIncome() * tax;
		if (getNumberEmployees() > 10) {
			return getIncome() * 0.14;
		} else {
			return getIncome() * 0.16;
		}
	}

}
