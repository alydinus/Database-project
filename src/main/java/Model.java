import dao.*;
import entities.Book;

import javax.swing.JOptionPane;
import java.util.List;

public class Model {
    private Viewer viewer;
    private BookDAO bookDao;
    private AuthorDAO authorDAO;
    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;
    private OrderItemsDAO orderItemsDAO;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        this.bookDao = new BookDAO();
        this.authorDAO = new AuthorDAO();
        this.customerDAO = new CustomerDAO();
        this.orderDAO = new OrderDAO();
        this.orderItemsDAO = new OrderItemsDAO();
    }


    public void createBook(String isbn, String title, int publicationYear, double price) {
        bookDao.createBook(isbn, title, publicationYear, price);
    }

    public void updateBook(String isbn, String title, int publicationYear, double price) {
        bookDao.updateBook(isbn, title, publicationYear, price);
    }

    public void deleteBook(String isbn) {
        bookDao.deleteBook(isbn);
    }

    public List<Book> showAllBooks() {
        return bookDao.readBooks();
    }

    public void executeOption(String option) {
        if (option.equals("Create book")) {
            createBook(viewer.getIsbn(), viewer.getTitle(), viewer.getPublicationYear(), viewer.getPrice());
            JOptionPane.showMessageDialog(viewer, "Book added successfully.");
        } else if (option.equals("Update book")) {
            updateBook(viewer.getIsbn(), viewer.getTitle(), viewer.getPublicationYear(), viewer.getPrice());
            JOptionPane.showMessageDialog(viewer, "Book updated successfully.");
        } else if (option.equals("Delete book")) {
            deleteBook(viewer.getIsbn());
            JOptionPane.showMessageDialog(viewer, "Book deleted successfully.");
        } else if (option.equals("Show all books")) {
            viewer.showAllBooks();
        } else if (option.equals("Create customer")) {

        } else if (option.equals("Update customer")) {

        } else if (option.equals("Delete customer")) {

        } else if (option.equals("Show all customers")) {

        } else if (option.equals("Create order")) {

        } else if (option.equals("Update order")) {

        } else if (option.equals("Delete order")) {

        } else if (option.equals("Show all orders")) {

        } else if (option.equals("Retrieve a list of books with their authors.")) {

        } else if (option.equals("Find the total sales for a specific book.")) {

        } else if (option.equals("List customers who made more than one purchase.")) {

        } else if (option.equals("Find the top N best-selling books.")) {

        } else if (option.equals("Identify authors with the highest total sales.")) {

        } else if (option.equals("Retrieve customers with the highest total purchase amount.")) {

        } else if (option.equals("Identify books with low stock.")) {

        } else if (option.equals("Retrieve the latest orders placed.")) {

        } else if (option.equals("Calculate total revenue.")) {

        } else if (option.equals("Identify customers who have not made a purchase.")) {

        }
    }


}
