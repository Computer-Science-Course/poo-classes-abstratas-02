package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Company;
import model.entities.Individual;
import model.entities.TaxPayer;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		List<TaxPayer> payers = new ArrayList<>();
		
		System.out.print("Enter the number of payers: ");
		Integer numberOfPayers = scanner.nextInt();
		
		for(Integer i = 1; i <= numberOfPayers; i++) {
			scanner = new Scanner(System.in);
			System.out.printf("Tax payer #%d data:\n", i);
			
			System.out.print("Individual or Company (i/c)? ");
			String payerType = scanner.nextLine();
			
			System.out.print("Name: ");
			String name = scanner.nextLine();
			
			System.out.print("Anual income: ");
			Double anualIncome = scanner.nextDouble();
			
			if(payerType.toLowerCase().equals("i")) {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = scanner.nextDouble();
				
				payers.add(new Individual(name, anualIncome, healthExpenditures));	
			}else if(payerType.toLowerCase().equals("c")) {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = scanner.nextInt();
				
				payers.add(new Company(name, anualIncome, numberOfEmployees));	
			}else {
				i--;
				System.out.println("Invalid type for TaxPayer");
			}
		}
		
		Double totalTaxes = 0.0;
		System.out.println("TAXES PAID:");
		for(TaxPayer payer: payers) {
			System.out.printf("%s: $ %.2f.\n", payer.getName(), payer.tax());
			totalTaxes += payer.tax();
		}
		
		System.out.printf("TOTAL TAXES: $ %.2f", totalTaxes);
		
		scanner.close();

	}

}
