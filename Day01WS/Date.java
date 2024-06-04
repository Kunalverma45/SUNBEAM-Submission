//////////////////////////////////////        QUESTION 01
import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;

    // Constructor to initialize with default values
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
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
            System.out.print("Enter today's day: ");
            this.day = scanner.nextInt();

            System.out.print("Enter today's month: ");
            this.month = scanner.nextInt();

            System.out.print("Enter today's year: ");
            this.year = scanner.nextInt();
        }
    }

    public static void main(String[] args) {
        Date date = new Date();

        // Initialize date with specific values
        date.initDate(4, 6, 2024);
        date.printDate();

        // Accept date values from the user
        date.acceptDate();
        date.printDate();
    }
}
