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
        JOptionPane.showMessageDialog(viewer, "Book added successfully");
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

    }


}
