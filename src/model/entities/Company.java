package model.entities;

public class Company extends TaxPayer{
	private Integer numberOfEmployees;
	
	public Company() {
		super();
	}
	
	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.setNumberOfEmployees(numberOfEmployees);
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		if(this.getNumberOfEmployees() > 10) {
			return this.getAnualIncome() * 0.14;
		} else {
			return this.getAnualIncome() * 0.16;			
		}
	}
	
}
