package entities;

public class OrderItem {
    private int orderID;
    private String bookISBN;
    private int quantity;

    public OrderItem(int orderID, String bookISBN, int quantity) {
        this.orderID = orderID;
        this.bookISBN = bookISBN;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public String getBookISBN() {
        return bookISBN;
    }
    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
