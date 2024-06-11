package Question02;

import java.util.*;
import java.text.ParseException;

public class LibraryBookManagement {
    private ArrayList<LibraryBook> books;
    private HashSet<String> isbnSet;

    public LibraryBookManagement() {
        books = new ArrayList<>();
        isbnSet = new HashSet<>();
    }

    public void displayAllBooks() {
        for (LibraryBook book : books) {
            System.out.println(book);
        }
    }

    public LibraryBook findBookByIsbn(String isbn) {
        for (LibraryBook book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean addNewBook(String isbn, LibraryBook.Category category, double price, String publishDate, String authorName, int quantity) {
        if (isbnSet.contains(isbn)) {
            System.out.println("ISBN already exists!");
            return false;
        }

        try {
            LibraryBook newBook = new LibraryBook(isbn, category, price, publishDate, authorName, quantity);
            books.add(newBook);
            isbnSet.add(isbn);
            return true;
        } catch (ParseException e) {
            System.out.println("Invalid publish date format. Please use dd-MM-yyyy.");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removeBook(String isbn) {
        LibraryBook book = findBookByIsbn(isbn);
        if (book != null) {
            books.remove(book);
            isbnSet.remove(isbn);
            return true;
        }
        return false;
    }

    public boolean editBookQuantity(String isbn, int newQuantity) {
        LibraryBook book = findBookByIsbn(isbn);
        if (book != null) {
            book.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    public void sortBooksByIsbn() {
        books.sort(Comparator.comparing(LibraryBook::getIsbn));
    }

    public void sortBooksByAuthor() {
        books.sort(Comparator.comparing(LibraryBook::getAuthorName));
    }

    public static void main(String[] args) {
        LibraryBookManagement bm = new LibraryBookManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Book Management");
            System.out.println("1. Display All Books");
            System.out.println("2. Find Book by ISBN");
            System.out.println("3. Add New Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Edit Book Quantity");
            System.out.println("6. Sort Books by ISBN");
            System.out.println("7. Sort Books by Author");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bm.displayAllBooks();
                    if (foundBook.size==0) {
                    System.out.println("no book found!!");
                    }
                break;
                case 2:
                    System.out.print("Enter ISBN to find: ");
                    String isbnToFind = scanner.nextLine();
                    LibraryBook foundBook = bm.findBookByIsbn(isbnToFind);
                    if (foundBook != null) {
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Category (SCIENCE, FICTION, HEALTH, HISTORY, MYSTERY, BIOGRAPHY): ");
                    String categoryStr = scanner.nextLine();
                    LibraryBook.Category category = LibraryBook.Category.valueOf(categoryStr.toUpperCase());
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Publish Date (dd-MM-yyyy): ");
                    String publishDate = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bm.addNewBook(isbn, category, price, publishDate, authorName, quantity);
                    break;
                case 4:
                    System.out.print("Enter ISBN to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    bm.removeBook(isbnToRemove);
                    break;
                case 5:
                    System.out.print("Enter ISBN to edit: ");
                    String isbnToEdit = scanner.nextLine();
                    System.out.print("Enter new Quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bm.editBookQuantity(isbnToEdit, newQuantity);
                    break;
                case 6:
                    bm.sortBooksByIsbn();
                    System.out.println("Books sorted by ISBN.");
                    bm.displayAllBooks();
                    break;
                case 7:
                    bm.sortBooksByAuthor();
                    System.out.println("Books sorted by Author.");
                    bm.displayAllBooks();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
