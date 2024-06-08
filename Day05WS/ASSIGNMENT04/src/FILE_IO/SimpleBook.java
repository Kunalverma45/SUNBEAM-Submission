package FILE_IO;

class SimpleBook {
    String isbn;
    Category category;
    double price;
    String publishDate;
    String authorName;
    int quantity;

    public SimpleBook(String isbn, Category category, double price, String publishDate, String authorName, int quantity) {
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
