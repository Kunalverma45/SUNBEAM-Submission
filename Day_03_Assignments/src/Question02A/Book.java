import java.util.Date;

public class Book {
    private String isbn;
    private Category category;
    private double price;
    private Date publishDate;
    private String authorName;
    private int quantity;

    public Book(String isbn, Category category, double price, Date publishDate, String authorName, int quantity) {
        this.isbn = isbn;
        this.category = category;
        this.price = price;
        this.publishDate = publishDate;
        this.authorName = authorName;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", authorName='" + authorName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}