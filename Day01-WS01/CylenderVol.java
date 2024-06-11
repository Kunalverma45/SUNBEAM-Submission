//////////////////////////////////////        QUESTION 03
import java.util.Scanner;

public class CylenderVol {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the Height of Cylinder = ");
            int height = scanner.nextInt();
            System.out.print("Enter the Radius of Cylinder = ");
            int Radius = scanner.nextInt();
            System.out.print("The Volume of the Cylinder is = "+(3.14*Radius*Radius*height));
        }
    }
}







