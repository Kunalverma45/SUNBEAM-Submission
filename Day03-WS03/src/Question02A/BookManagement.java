import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    private List<Book> books;

    public BookManagement() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            books.remove(book);
            return true;
        }
        return false;
    }

    public boolean editBookQuantity(String isbn, int newQuantity) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            book.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ParseException {
        BookManagement bm = new BookManagement();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        boolean running = true;

        while (running) {
            System.out.println("-------------------------------------------------------------------------------------------"
            		+ "\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Find Book by ISBN");
            System.out.println("4. Remove Book");
            System.out.println("5. Edit Book Quantity");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter Category (SCIENCE, FICTION, HEALTH): ");
                    Category category = Category.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Publish Date (dd-MM-yyyy): ");
                    Date publishDate = sdf.parse(scanner.nextLine());

                    System.out.print("Enter Author Name: ");
                    String authorName = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    bm.addBook(new Book(isbn, category, price, publishDate, authorName, quantity));
                    System.out.println("ADDED BOOK SUCCESSFULLYY...");
                    break;

                case 2:
                    System.out.println("All books:");
                    bm.displayAllBooks();
                    break;

                case 3:
                    System.out.print("Enter ISBN to find: ");
                    isbn = scanner.nextLine();
                    Book book = bm.findBookByIsbn(isbn);
                    if (book != null) {
                        System.out.println(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ISBN to remove: ");
                    isbn = scanner.nextLine();
                    if (bm.removeBook(isbn)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ISBN to edit: ");
                    isbn = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    if (bm.editBookQuantity(isbn, quantity)) {
                        System.out.println("Book quantity updated.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}