//////////////////////////////////////        QUESTION 04
import java.util.Scanner;

public class FoodOrderSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Menu prices
            int[] prices = {50, 20, 30, 25, 40, 15, 35, 45, 60, 0}; // Last item price is 0 for "Generate Bill"

            int choice;
            int totalBill = 0;

            do {
                // Display menu
                System.out.println("Menu:");
                System.out.println("1. Dosa - Rs. 50");
                System.out.println("2. Samosa - Rs. 20");
                System.out.println("3. Idli - Rs. 30");
                System.out.println("4. Vada - Rs. 25");
                System.out.println("5. Paneer Tikka - Rs. 40");
                System.out.println("6. Pakoda - Rs. 15");
                System.out.println("7. Chole Bhature - Rs. 35");
                System.out.println("8. Pulao - Rs. 45");
                System.out.println("9. Biryani - Rs. 60");
                System.out.println("10. Generate Bill");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                if (choice >= 1 && choice <= 9) {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    totalBill += prices[choice - 1] * quantity;
                } else if (choice == 10) {
                    // Generate bill
                    System.out.println("Total Bill: Rs. " + totalBill);
                    System.out.println("Thank you for your order!");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 10);
        }
    }
}
