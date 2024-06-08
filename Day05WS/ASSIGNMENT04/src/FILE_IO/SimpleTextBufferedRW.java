package FILE_IO;

import java.io.IOException;

public class SimpleTextBufferedRW {
    public static void main(String[] args) {
        SimpleBookManagement bookManagement = new SimpleBookManagement();

        // Add sample data
        bookManagement.addSampleData();

        // Display all books
        System.out.println("All Books:");
        bookManagement.displayAllBooks();

        // Find a particular book
        System.out.println("\nFind Book with ISBN book-0003:");
        SimpleBook book = bookManagement.findBook("book-0003");
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }

        // Add a new book
        System.out.println("\nAdding a new book:");
        SimpleBook newBook = new SimpleBook("book-0010", Category.FICTION, 800, "10-10-2020", "Mohan", 25);
        bookManagement.addBook(newBook);
        bookManagement.displayAllBooks();

        // Remove a book
        System.out.println("\nRemoving book with ISBN book-0004:");
        bookManagement.removeBook("book-0004");
        bookManagement.displayAllBooks();

        // Edit book quantity
        System.out.println("\nEditing quantity of book with ISBN book-0005:");
        bookManagement.editBookQuantity("book-0005", 18);
        bookManagement.displayAllBooks();

        // Save books to file
        try {
            bookManagement.saveBooks();
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }

        // Load books from file and display
        SimpleBookManagement bookManagementFromFile = new SimpleBookManagement();
        try {
            bookManagementFromFile.loadBooks();
            System.out.println("\nBooks loaded from file:");
            bookManagementFromFile.displayAllBooks();
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }
}
