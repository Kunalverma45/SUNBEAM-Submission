package FILE_IO;

import java.io.IOException;
import java.util.Scanner;

public class TextBufferedRW {
    static Scanner sc = new Scanner(System.in);
    static BookManagement bookManagement = new BookManagement();

    public static int menuList() {
        System.out.println("-------------------------------------------------------------"
                + "\nEnter the Option:\n0. Exit\n1. Display All Books\n2. Find Book\n3. Add New Book\n4. Remove Book\n5. Edit Book Quantity\n6. Save and Exit");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        return choice;
    }

    public static void main(String[] args) {
        try {
            bookManagement.loadBooks();
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }

        int choice;
        while ((choice = menuList()) != 0) {
            switch (choice) {
                case 1:
                    bookManagement.displayAllBooks();
                    break;
                case 2:
                    System.out.print("Enter ISBN to find: ");
                    String isbnFind = sc.nextLine();
                    Book book = bookManagement.findBook(isbnFind);
                    if (book != null) {
                        System.out.println(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter Category (SCIENCE, FICTION, HEALTH): ");
                    Category category = Category.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Publish Date: ");
                    String publishDate = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String authorName = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine(); // consume newline
                    bookManagement.addBook(new Book(isbn, category, price, publishDate, authorName, quantity));
                    break;
                case 4:
                    System.out.print("Enter ISBN to remove: ");
                    String isbnRemove = sc.nextLine();
                    bookManagement.removeBook(isbnRemove);
                    break;
                case 5:
                    System.out.print("Enter ISBN to edit quantity: ");
                    String isbnEdit = sc.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine(); // consume newline
                    bookManagement.editBookQuantity(isbnEdit, newQuantity);
                    break;
                case 6:
                    try {
                        bookManagement.saveBooks();
                    } catch (IOException e) {
                        System.out.println("Error saving books: " + e.getMessage());
                    }
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Put the valid input");
                    break;
            }
        }
    }
}
