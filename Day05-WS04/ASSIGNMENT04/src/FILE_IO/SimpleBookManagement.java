package FILE_IO;

import java.io.*;
import java.util.*;

class SimpleBookManagement {
    private static final String FILE_NAME = "SimpleQuestion01.txt";
    private List<SimpleBook> books = new ArrayList<>();

    public void displayAllBooks() {
        for (SimpleBook book : books) {
            System.out.println(book);
        }
    }

    public SimpleBook findBook(String isbn) {
        for (SimpleBook book : books) {
            if (book.isbn.equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(SimpleBook book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.isbn.equals(isbn));
    }

    public void editBookQuantity(String isbn, int quantity) {
        SimpleBook book = findBook(isbn);
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
                books.add(new SimpleBook(isbn, category, price, publishDate, authorName, quantity));
            }
        }
    }

    public void saveBooks() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(FILE_NAME)))) {
            for (SimpleBook book : books) {
                bw.write(book.toString());
                bw.newLine();
            }
        }
    }

    public void addSampleData() {
        books.add(new SimpleBook("book-0001", Category.SCIENCE, 500, "12-3-2020", "Rama", 10));
        books.add(new SimpleBook("book-0009", Category.FICTION, 400, "12-12-2010", "Kishor", 20));
        books.add(new SimpleBook("book-0003", Category.SCIENCE, 1500, "1-3-2021", "Shubham", 15));
        books.add(new SimpleBook("book-0005", Category.SCIENCE, 600, "12-3-2020", "Rama", 12));
        books.add(new SimpleBook("book-0004", Category.HEALTH, 700, "12-3-2020", "Rama", 30));
    }
}
