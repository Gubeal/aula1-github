package entities;

public abstract class Payer {
	private String name;
	private Double income;
	
	public Payer(String name, Double income) {
		super();
		this.name = name;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
	
	public abstract Double tax();
	
	public String toString() {
		return name + ": $ " + String.format("%.2f", tax());
	}
}
