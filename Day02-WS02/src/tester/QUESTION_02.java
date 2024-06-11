//package tester;
//
//import java.util.Scanner;
//
//public class QUESTION_02 {
//	public static void main(String[] args) {
////		System.out.println("Hello World");
//try (Scanner scanner = new Scanner(System.in)) {
//			
//            int choice;
//            do {
//                System.out.println("\nMenu:\n"
//                		+"1. Hire Manager\n"
//                		+ "2. Hire Worker \n"
//                		+ "3. Display information of all employees , including net salary using for-each loop. \n"
//                		+ "4. Update basic salary\n"
//                		+ "5. Exit");
//                System.out.print("Enter your choice: ");
//                choice = scanner.nextInt();
//
//                switch (choice) {
//                    case 1:
//                		System.out.println();
//                        break;
//                    case 2:
//                		System.out.println("Hello World 02");
//                        break;
//                    case 3:
//                		System.out.println("Hello World 03");
//                        break;
//                    case 4:
//                		System.out.println("Hello World 04");
//                        break;
//                    case 5:
//                        System.out.println("Exiting program.");
//                		break;
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            } while (choice != 5);
//		}
//	}
//}






package tester;

import java.util.ArrayList;
import java.util.Scanner;

public class QUESTION_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        int choice;

        do {
            System.out.println("Options:");
            System.out.println("1. Hire Manager");
            System.out.println("2. Hire Worker");
            System.out.println("3. Display information of all employees");
            System.out.println("4. Update basic salary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Manager's name: ");
                    String managerName = sc.nextLine();
                    System.out.print("Enter Manager's basic salary: ");
                    double managerSalary = sc.nextDouble();
                    employees.add(new Manager(managerName, managerSalary));
                    break;

                case 2:
                    System.out.print("Enter Worker's name: ");
                    String workerName = sc.nextLine();
                    System.out.print("Enter Worker's basic salary: ");
                    double workerSalary = sc.nextDouble();
                    employees.add(new Worker(workerName, workerSalary));
                    break;

                case 3:
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;

                case 4:
                    System.out.print("Enter employee name to update salary: ");
                    String nameToUpdate = sc.nextLine();
                    boolean found = false;
                    for (Employee emp : employees) {
                        if (emp.getName().equalsIgnoreCase(nameToUpdate)) {
                            System.out.print("Enter new basic salary: ");
                            double newSalary = sc.nextDouble();
                            emp.setBasicSalary(newSalary);
                            System.out.println("Salary updated for " + emp.getName());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
