//////////////////////////////////////        QUESTION OR
import java.util.Scanner;

class Fruit {
    protected String color;
    protected double weight;
    protected String name;
    protected boolean isFresh;

    public Fruit(String name, String color, double weight, boolean isFresh) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.isFresh = isFresh;
    }

    public String taste() {
        return "no specific taste";
    }

    @Override
    public String toString() {
        return "Fruit{name='" + name + "', color='" + color + "', weight=" + weight + ", isFresh=" + isFresh + "}";
    }

    public boolean isFresh() {
        return isFresh;
    }

    public String getName() {
        return name;
    }
}

class Apple extends Fruit {
    public Apple(String name, String color, double weight, boolean isFresh) {
        super(name, color, weight, isFresh);
    }

    @Override
    public String taste() {
        return "sweet n sour";
    }
}

class Mango extends Fruit {
    public Mango(String name, String color, double weight, boolean isFresh) {
        super(name, color, weight, isFresh);
    }

    @Override
    public String taste() {
        return "sweet";
    }
}

class Orange extends Fruit {
    public Orange(String name, String color, double weight, boolean isFresh) {
        super(name, color, weight, isFresh);
    }

    @Override
    public String taste() {
        return "sour";
    }
}

public class FruitBasket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the basket size: ");
        int basketSize = scanner.nextInt();
        Fruit[] basket = new Fruit[basketSize];
        int counter = 0;

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("0. Exit");
            System.out.println("1. Add Mango");
            System.out.println("2. Add Orange");
            System.out.println("3. Add Apple");
            System.out.println("4. Display names of all fruits in the basket");
            System.out.println("5. Display name, color, weight, taste of all fresh fruits in the basket");
            System.out.println("6. Display tastes of all stale (not fresh) fruits in the basket");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    if (counter < basketSize) {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter color: ");
                        String color = scanner.nextLine();
                        System.out.print("Enter weight: ");
                        double weight = scanner.nextDouble();
                        basket[counter++] = new Mango(name, color, weight, true);
                        System.out.println("Mango added to basket.");
                    } else {
                        System.out.println("Basket is full.");
                    }
                    break;
                case 2:
                    if (counter < basketSize) {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter color: ");
                        String color = scanner.nextLine();
                        System.out.print("Enter weight: ");
                        double weight = scanner.nextDouble();
                        basket[counter++] = new Orange(name, color, weight, true);
                        System.out.println("Orange added to basket.");
                    } else {
                        System.out.println("Basket is full.");
                    }
                    break;
                case 3:
                    if (counter < basketSize) {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter color: ");
                        String color = scanner.nextLine();
                        System.out.print("Enter weight: ");
                        double weight = scanner.nextDouble();
                        basket[counter++] = new Apple(name, color, weight, true);
                        System.out.println("Apple added to basket.");
                    } else {
                        System.out.println("Basket is full.");
                    }
                    break;
                case 4:
                    System.out.println("Names of all fruits in the basket:");
                    for (Fruit fruit : basket) {
                        if (fruit != null) {
                            System.out.println(fruit.getName());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Details of all fresh fruits in the basket:");
                    for (Fruit fruit : basket) {
                        if (fruit != null && fruit.isFresh()) {
                            System.out.println(fruit.toString() + ", Taste: " + fruit.taste());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Tastes of all stale (not fresh) fruits in the basket:");
                    for (Fruit fruit : basket) {
                        if (fruit != null && !fruit.isFresh()) {
                            System.out.println(fruit.taste());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
