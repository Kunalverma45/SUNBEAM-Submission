package com.app.org;

import java.util.*;

public class QUESTION_01 {
	public static void main(String[] args) {
		Emp emp = new Emp(1, "John Doe", "HR", 50000);
		Mgr mgr = new Mgr(2, "Jane Smith", "IT", 70000, 15000);
		Worker worker = new Worker(3, "Bob Brown", "Maintenance", 30000, 160, 20);
		try (Scanner scanner = new Scanner(System.in)) {
			
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Employe's Detail");
                System.out.println("2. Manager's Detail & Manager's Net Salary");
                System.out.println("3. Worker's Details & Manager's Net Salary");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                    	System.out.println(emp);
                        break;
                    case 2:
                    	System.out.println(mgr);
                    	System.out.println("Manager's Net Salary: " + mgr.computeNetSalary());
                        break;
                    case 3:
                    	System.out.println(worker);
                    	System.out.println("Worker's Net Salary: " + worker.computeNetSalary());
                        break;
                    case 4:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        }
    }
}
