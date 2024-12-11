import dao.*;
import entities.Book;

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

    // Book-related methods
    public void createBook(String isbn, String title, int publicationYear, double price) {
        bookDao.createBook(isbn, title, publicationYear, price);
    }

    public void updateBook(String isbn, String title, int publicationYear, double price) {
        bookDao.updateBook(isbn, title, publicationYear, price);
    }

    public void deleteBook(String isbn) {
        bookDao.deleteBook(isbn);
    }

    public List<Book> readBooks() {
        return bookDao.readBooks();
    }

    // Author-related methods
    public void createAuthor(String firstName, String lastName) {
        authorDAO.createAuthor(firstName, lastName);
    }

    public void updateAuthor(int authorId, String firstName, String lastName) {
        authorDAO.updateAuthor(authorId, firstName, lastName);
    }

    public void deleteAuthor(int authorId) {
        authorDAO.deleteAuthor(authorId);
    }

    public List<String> readAuthors() {
        return authorDAO.readAuthors(); // Assuming this method returns a list of authors
    }

    // Customer-related methods
    public void createCustomer(String name, String address) {
        customerDAO.createCustomer(name, address);
    }

    public void updateCustomer(int customerId, String name, String address) {
        customerDAO.updateCustomer(customerId, name, address);
    }

    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }

    public List<String> readCustomers() {
        return customerDAO.readCustomers(); // Assuming this method returns a list of customers
    }

    // Order-related methods
    public void createOrder(int customerId, String orderDate) {
        orderDAO.createOrder(customerId, orderDate);
    }

    public void updateOrder(int orderId, String orderDate) {
        orderDAO.updateOrder(orderId, orderDate);
    }

    public void deleteOrder(int orderId) {
        orderDAO.deleteOrder(orderId);
    }

    public List<String> readOrders() {
        return orderDAO.readOrders(); // Assuming this method returns a list of orders
    }

    // Order Items-related methods
    public void createOrderItem(int orderId, String bookIsbn, int quantity) {
        orderItemsDAO.createOrderItem(orderId, bookIsbn, quantity);
    }

    public void updateOrderItem(int orderId, String bookIsbn, int quantity) {
        orderItemsDAO.updateOrderItem(orderId, bookIsbn, quantity);
    }

    public void deleteOrderItem(int orderId, String bookIsbn) {
        orderItemsDAO.deleteOrderItem(orderId, bookIsbn);
    }

    public void readOrderItems(int orderId) {
        orderItemsDAO.readOrderItems(orderId);
    }
}
