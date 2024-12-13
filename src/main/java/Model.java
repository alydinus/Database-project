import dao.*;
import entities.Author;
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
        JOptionPane.showMessageDialog(viewer, "Book updated successfully");
    }

    public boolean isbnExists(String isbn) {
        return bookDao.isbnExists(isbn);
    }

    public void deleteBook(String isbn) {
        bookDao.deleteBook(isbn);
        JOptionPane.showMessageDialog(viewer, "Book deleted successfully");
    }

    public List<Book> showAllBooks() {
        return bookDao.readBooks();
    }

    public void createAuthor(String name, String surname) {
        authorDAO.createAuthor(name, surname);
        JOptionPane.showMessageDialog(viewer, "Author added successfully");
    }

    public void updateAuthor(int id, String name, String surname) {
        authorDAO.updateAuthor(id, name, surname);
        JOptionPane.showMessageDialog(viewer, "Author updated successfully");
    }

    public boolean authorExists(int id) {
        return authorDAO.idExists(id);
    }

    public void deleteAuthor(int id) {
        authorDAO.deleteAuthor(id);
        JOptionPane.showMessageDialog(viewer, "Author deleted successfully");
    }

    public List<Author> showAllAuthors() {
        return authorDAO.showAuthors();
    }

    public void exit() {
        System.exit(0);
    }




}
