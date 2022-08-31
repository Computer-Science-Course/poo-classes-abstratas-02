package model.entities;

public class Individual extends TaxPayer{

	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.setHealthExpenditures(healthExpenditures);
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		Double discount = this.getHealthExpenditures() * 0.5;
		
		if(this.getAnualIncome() < 20000) {
			return (this.getAnualIncome() * 0.15) - discount;
		}else {
			return (this.getAnualIncome() * 0.25) - discount;
		}		
	}
	
	
}
