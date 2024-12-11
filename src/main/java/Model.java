import dao.*;

import java.util.List;

public class Model {
    private Viewer viewer;
    private BookDAO bookDao;
    private AuthorDAO authorDAO;
    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;
    private OrderItemsDAO orderItemsDAO;
    private AdminDAO adminDAO;
    public Model(Viewer viewer) {
        this.viewer = viewer;
        this.bookDao = new BookDAO();
        this.authorDAO = new AuthorDAO();
        this.customerDAO = new CustomerDAO();
        this.orderDAO = new OrderDAO();
        this.orderItemsDAO = new OrderItemsDAO();
        this.adminDAO = new AdminDAO();
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
    public void readBook(String isbn) {
        bookDao.readBook(isbn);
    }

    public void createAuthor( String firstName, String lastName) {
        authorDAO.createAuthor( firstName, lastName);
    }

    public void updateAuthor(int authorId, String firstName, String lastName) {
        authorDAO.updateAuthor(authorId, firstName, lastName);
    }

    public void deleteAuthor(int authorId) {
        authorDAO.deleteAuthor(authorId);
    }

    public void readAuthor(int authorId) {
        authorDAO.readAuthor(authorId);
    }


    public void createCustomer( String name, String address) {
        customerDAO.createCustomer( name, address);
    }

    public void updateCustomer(int customerId, String name, String address) {
        customerDAO.updateCustomer(customerId, name, address);
    }

    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }

    public void readCustomer(int customerId) {
        customerDAO.readCustomer(customerId);
    }

    public void createOrder( int customerId, String orderDate) {
        orderDAO.createOrder( customerId, orderDate);
    }

    public void updateOrder(int orderId, String orderDate) {
        orderDAO.updateOrder(orderId, orderDate);
    }

    public void deleteOrder(int orderId) {
        orderDAO.deleteOrder(orderId);
    }

    public void readOrder(int orderId) {
        orderDAO.readOrder(orderId);
    }

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

    public void createAdmin(String username, String password) {
        adminDAO.create(username, password);
    }

    public void updateAdmin(String username, String password) {
        adminDAO.update(username, password);
    }

    public void deleteAdmin(String username, String password) {
        adminDAO.delete(username, password);
    }

    public List<String> readAdmin() {
        return adminDAO.read();
    }



}
