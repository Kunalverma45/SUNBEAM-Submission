package FILE_IO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class STUDENTMANAGEMENT {
    private static final String FILE_NAME = "Question02.bin";
    private List<STUDENT> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Roll No: ");
        String rollNo = scanner.nextLine(); // Read the entire line including newline character
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        String dobStr = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobStr, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.print("Enter Subject (JAVA, DBT, ANGULAR, REACT, SE): ");
        SUBJECT subject = SUBJECT.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter GPA: ");
        double GPA = Double.parseDouble(scanner.nextLine());

        STUDENT student = new STUDENT(rollNo, name, dob, subject, GPA);
        students.add(student);
    }


    public void displayAllStudents() {
        for (STUDENT student : students) {
            System.out.println(student);
        }
    }

    public STUDENT findStudent(String rollNo) {
        for (STUDENT student : students) {
            if (student.getRollNo().equals(rollNo)) {
                return student;
            }
        }
        return null;
    }

    public void cancelAdmission(String rollNo) {
        students.removeIf(student -> student.getRollNo().equals(rollNo));
    }

    public void saveStudents() {
        try {
            SERDESERUTILS.serializeStudents(students, FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public void loadStudents() {
        try {
            students = SERDESERUTILS.deserializeStudents(FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        STUDENTMANAGEMENT management = new STUDENTMANAGEMENT();
        management.loadStudents();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Display All Students");
            System.out.println("2. Retrieve Student Details");
            System.out.println("3. Admit New Student");
            System.out.println("4. Cancel Admission");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    management.displayAllStudents();
                    break;
                case 2:
                    System.out.print("Enter Roll No: ");
                    String rollNo = scanner.next();
                    STUDENT student = management.findStudent(rollNo);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    management.addStudent();
                    break;
                case 4:
                    System.out.print("Enter Roll No to cancel admission: ");
                    String rollNoToCancel = scanner.next();
                    management.cancelAdmission(rollNoToCancel);
                    break;
                case 5:
                    management.saveStudents();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
