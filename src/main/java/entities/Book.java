package entities;

public class Book {
    private String isbn;
    private String title;
    private int publicationYear;
    private double price;

    public Book(String isbn, String title, int publicationYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
