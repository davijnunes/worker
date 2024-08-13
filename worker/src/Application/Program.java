package Application;

import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) {
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		Department department = new Department(departmentName);
		
		System.out.println();
		
		System.out.println("Enter worker data: ");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Level: ");
		WorkerLevel level = WorkerLevel.valueOf(sc.next());
		
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name,level,baseSalary,department);
		
		System.out.println();
		
		System.out.print("How many contracts to this worker? ");
		int quantityOfContract = sc.nextInt();
		
		
		for(int i = 0; i < quantityOfContract; i++) {
			
			System.out.println("Enter contract #" + (i+i) +" data:");
			
			System.out.print("Date (DD/MM/YYYY): ");
			LocalDate date = LocalDate.parse(sc.next(), dtf);
			
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			worker.addContract(new HourContract(date,valuePerHour,hours));
			
			System.out.println();
			
		}
		
		System.out.println();
		
		
		System.out.print("Enter month and year to calculate income (MM/YY): ");
		LocalDate date =  LocalDate.parse(sc.next(),dtf);
		
		System.out.println();
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.printf("Income for %d/%d: %.2f",
				date.getMonthValue(),date.getYear(), worker.income(date.getYear(), date.getMonthValue())
				);
		
		
		
		sc.close();
		
	}

}
