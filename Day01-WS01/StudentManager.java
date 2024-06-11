//////////////////////////////////////        QUESTION 05B
import java.util.Scanner;

class Student {
    private int rollNo;
    private String name;
    private double marks;

    // Parameterless constructor to initialize default values
    public Student() {
        this.rollNo = 0;
        this.name = "Unknown";
        this.marks = 0.0;
    }

    // Method to accept student details from the user
    public void acceptStudentDetails() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Roll No: ");
            this.rollNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            this.name = scanner.nextLine();

            System.out.print("Enter Marks: ");
            this.marks = scanner.nextDouble();
        }
    }

    // Method to print student details
    public void printStudentDetails() {
        System.out.println("Student Details:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Initialize Student with Default Values");
            System.out.println("2. Accept Student Details");
            System.out.println("3. Print Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    student = new Student(); // Reinitialize student with default values
                    System.out.println("Student initialized with default values.");
                    break;
                case 2:
                    student.acceptStudentDetails();
                    break;
                case 3:
                    student.printStudentDetails();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
