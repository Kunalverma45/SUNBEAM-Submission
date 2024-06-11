//////////////////////////////////////        QUESTION 05A
import java.util.Scanner;

class Date {
    private int day;
    private int month;
    private int year;

    // Parameterless constructor to initialize default values
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    // Method to initialize the date with specific values
    public void initDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Method to print the date in DD-MM-YYYY format
    public void printDate() {
        System.out.printf("%02d-%02d-%d\n", day, month, year);
    }

    // Method to accept date values from the user
    public void acceptDate() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter day: ");
            this.day = scanner.nextInt();

            System.out.print("Enter month: ");
            this.month = scanner.nextInt();

            System.out.print("Enter year: ");
            this.year = scanner.nextInt();
        }
    }
}

public class DateManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Initialize Date with Default Values");
            System.out.println("2. Accept Date from User");
            System.out.println("3. Print Date");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    date = new Date(); // Reinitialize date with default values
                    System.out.println("Date initialized with default values.");
                    break;
                case 2:
                    date.acceptDate();
                    break;
                case 3:
                    date.printDate();
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
