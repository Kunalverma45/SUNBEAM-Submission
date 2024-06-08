package FILE_IO;

import java.io.*;
import java.util.*;

enum Category {
    SCIENCE, FICTION, HEALTH;
}

class Book {
    String isbn;
    Category category;
    double price;
    String publishDate;
    String authorName;
    int quantity;

    public Book(String isbn, Category category, double price, String publishDate, String authorName, int quantity) {
        this.isbn = isbn;
        this.category = category;
        this.price = price;
        this.publishDate = publishDate;
        this.authorName = authorName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return isbn + " " + category + " " + price + " " + publishDate + " " + authorName + " " + quantity;
    }
}

class BookManagement {
    private static final String FILE_NAME = "Question01.txt";
    private List<Book> books = new ArrayList<>();

    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.isbn.equals(isbn));
    }

    public void editBookQuantity(String isbn, int quantity) {
        Book book = findBook(isbn);
        if (book != null) {
            book.quantity = quantity;
        }
    }

    public void loadBooks() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_NAME)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                String isbn = data[0];
                Category category = Category.valueOf(data[1].toUpperCase());
                double price = Double.parseDouble(data[2]);
                String publishDate = data[3];
                String authorName = data[4];
                int quantity = Integer.parseInt(data[5]);
                books.add(new Book(isbn, category, price, publishDate, authorName, quantity));
            }
        }
    }

    public void saveBooks() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(FILE_NAME)))) {
            for (Book book : books) {
                bw.write(book.toString());
                bw.newLine();
            }
        }
    }
}
