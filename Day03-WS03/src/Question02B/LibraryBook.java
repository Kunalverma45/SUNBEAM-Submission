package Question02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LibraryBook {
    public enum Category {
        SCIENCE, FICTION, HEALTH, HISTORY, MYSTERY, BIOGRAPHY
    }

    private String isbn;
    private Category category;
    private double price;
    private Date publishDate;
    private String authorName;
    private int quantity;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public LibraryBook(String isbn, Category category, double price, String publishDate, String authorName, int quantity) throws ParseException {
        this.isbn = isbn;
        this.category = category;
        this.price = price;
        this.publishDate = dateFormat.parse(publishDate);
        this.authorName = authorName;
        this.quantity = quantity;

        if (!isValidPublishDate(this.publishDate)) {
            throw new IllegalArgumentException("Publish date should be in the financial year (1st Apr 2023 to 31st Mar 2024)");
        }
    }

    private boolean isValidPublishDate(Date publishDate) {
        Calendar cal = Calendar.getInstance();
        cal.set(2023, Calendar.APRIL, 1); // Start date: 1st Apr 2023
        Date startDate = cal.getTime();
        cal.set(2024, Calendar.MARCH, 31); // End date: 31st Mar 2024
        Date endDate = cal.getTime();

        return publishDate.after(startDate) && publishDate.before(endDate);
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public Category getCategory() { return category; }
    public double getPrice() { return price; }
    public Date getPublishDate() { return publishDate; }
    public String getAuthorName() { return authorName; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return isbn + " " + category + " " + price + " " + dateFormat.format(publishDate) + " " + authorName + " " + quantity;
    }
}
