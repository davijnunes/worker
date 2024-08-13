package Entities;

import java.util.List;
import java.util.ArrayList;
import Entities.enums.WorkerLevel;
import Entities.Department;
import Entities.HourContract;
import java.time.LocalDate;

public class Worker {
	
	private String name;
	private WorkerLevel level ;
	private Double baseSalary;
	
	Department department;
	
	List<HourContract> contracts = new ArrayList<HourContract>();
	
	
	public Worker() {
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		
		this.name = name;
		
		this.level = level;
		
		this.baseSalary = baseSalary;
		
		this.department = department;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public void addContract(HourContract contract) {
		
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		
		contracts.remove(contract);
	}
	
	// return base salary more value of contract
	public double income(int year, int month) {
		
		double sum = baseSalary;
		
		for(HourContract c: contracts) {
			
			
			if(
					c.getDate().getYear() == year && c.getDate().getMonthValue() == month
					) {
				
				sum += c.valueTotal();
				
				
			}	
		}
		
		return sum;
		
		
	}
	
	
	
	
	
	
	
}
