import dao.*;

public class Model {
    private Viewer viewer;
    public Model(Viewer viewer) {
        this.viewer = viewer;
    }

    public void createBook(String isbn, String title, int publicationYear, double price) {
        BookDao.createBook(isbn, title, publicationYear, price);
    }
    public void updateBook(String isbn, String title, int publicationYear, double price) {
        BookDao.updateBook(isbn, title, publicationYear, price);
    }
    public void deleteBook(String isbn) {
        BookDao.deleteBook(isbn);
    }
    public void readBook(String isbn) {
        BookDao.readBook(isbn);
    }

    public void createAuthor( String firstName, String lastName) {
        AuthorDAO.createAuthor( firstName, lastName);
    }

    public void updateAuthor(int authorId, String firstName, String lastName) {
        AuthorDAO.updateAuthor(authorId, firstName, lastName);
    }

    public void deleteAuthor(int authorId) {
        AuthorDAO.deleteAuthor(authorId);
    }

    public void readAuthor(int authorId) {
        AuthorDAO.readAuthor(authorId);
    }


    public void createCustomer( String name, String address) {
        CustomerDAO.createCustomer( name, address);
    }

    public void updateCustomer(int customerId, String name, String address) {
        CustomerDAO.updateCustomer(customerId, name, address);
    }

    public void deleteCustomer(int customerId) {
        CustomerDAO.deleteCustomer(customerId);
    }

    public void readCustomer(int customerId) {
        CustomerDAO.readCustomer(customerId);
    }

    public void createOrder( int customerId, String orderDate) {
        OrderDAO.createOrder( customerId, orderDate);
    }

    public void updateOrder(int orderId, String orderDate) {
        OrderDAO.updateOrder(orderId, orderDate);
    }

    public void deleteOrder(int orderId) {
        OrderDAO.deleteOrder(orderId);
    }

    public void readOrder(int orderId) {
        OrderDAO.readOrder(orderId);
    }

    public void createOrderItem(int orderId, String bookIsbn, int quantity) {
        OrderItemsDAO.createOrderItem(orderId, bookIsbn, quantity);
    }

    public void updateOrderItem(int orderId, String bookIsbn, int quantity) {
        OrderItemsDAO.updateOrderItem(orderId, bookIsbn, quantity);
    }

    public void deleteOrderItem(int orderId, String bookIsbn) {
        OrderItemsDAO.deleteOrderItem(orderId, bookIsbn);
    }

    public void readOrderItems(int orderId) {
        OrderItemsDAO.readOrderItems(orderId);
    }



}
