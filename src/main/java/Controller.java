import entities.Book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Controller extends MouseAdapter implements ActionListener {
    private Viewer viewer;
    private Model model;

    public Controller(Viewer viewer) {
        this.viewer = viewer;
        this.model = new Model(viewer);
    }

    public void actionPerformed(ActionEvent e) {
        // Handling button actions for creating, updating, deleting, and reading
        if (e.getActionCommand().equals("createBook")) {
            String isbn = viewer.getBookIsbnField().getText();
            String title = viewer.getBookTitleField().getText();
            int publicationYear = Integer.parseInt(viewer.getBookYearField().getText());
            double price = Double.parseDouble(viewer.getBookPriceField().getText());

            model.createBook(isbn, title, publicationYear, price);
        } else if (e.getActionCommand().equals("updateBook")){
            String isbn = viewer.getBookIsbnField().getText();
            String title = viewer.getBookTitleField().getText();
            int publicationYear = Integer.parseInt(viewer.getBookYearField().getText());
            double price = Double.parseDouble(viewer.getBookPriceField().getText());

            model.updateBook(isbn, title, publicationYear, price);
        } else if (e.getActionCommand().equals("deleteBook")){
            String isbn = viewer.getBookIsbnField().getText();
            model.deleteBook(isbn);
        } else if (e.getActionCommand().equals("createAuthor")){
            String firstName = viewer.getAuthorFirstNameField().getText();
            String lastName = viewer.getAuthorLastNameField().getText();
            model.createAuthor(firstName, lastName);
        } else if (e.getActionCommand().equals("updateAuthor")){
            int authorId = Integer.parseInt(viewer.getAuthorIdField().getText());
            String firstName = viewer.getAuthorFirstNameField().getText();
            String lastName = viewer.getAuthorLastNameField().getText();
            model.updateAuthor(authorId, firstName, lastName);
        } else if (e.getActionCommand().equals("deleteAuthor")){
            int authorId = Integer.parseInt(viewer.getAuthorIdField().getText());
            model.deleteAuthor(authorId);
        } else if (e.getActionCommand().equals("createCustomer")){
            String name = viewer.getCustomerNameField().getText();
            String address = viewer.getCustomerAddressField().getText();
            model.createCustomer(name, address);
        } else if (e.getActionCommand().equals("updateCustomer")){
            int customerId = Integer.parseInt(viewer.getCustomerIdField().getText());
            String name = viewer.getCustomerNameField().getText();
            String address = viewer.getCustomerAddressField().getText();
            model.updateCustomer(customerId, name, address);
        } else if (e.getActionCommand().equals("deleteCustomer")){
            int customerId = Integer.parseInt(viewer.getCustomerIdField().getText());
            model.deleteCustomer(customerId);
        } else if (e.getActionCommand().equals("createOrder")){
            int customerId = Integer.parseInt(viewer.getCustomerIdField().getText());
            String orderDate = viewer.getOrderDateField().getText();
            model.createOrder(customerId, orderDate);
        } else if (e.getActionCommand().equals("updateOrder")){
            int orderId = Integer.parseInt(viewer.getOrderIdField().getText());
            int customerId = Integer.parseInt(viewer.getCustomerIdField().getText());
            String orderDate = viewer.getOrderDateField().getText();
            model.updateOrder(orderId, orderDate);
        } else if (e.getActionCommand().equals("deleteOrder")){
            int orderId = Integer.parseInt(viewer.getOrderIdField().getText());
            model.deleteOrder(orderId);
        }

        // Show List actions for books, authors, customers, and orders
        if (e.getActionCommand().equals("showBookList")) {
            List<Book> bookList = model.readBooks();
            viewer.getBookListArea().setText(bookList);  // Displaying book list in JTextArea
        } else if (e.getActionCommand().equals("showAuthorList")) {
            String authorList = model.getAuthorList();
            viewer.getAuthorListArea().setText(authorList);  // Displaying author list in JTextArea
        } else if (e.getActionCommand().equals("showCustomerList")) {
            String customerList = model.getCustomerList();
            viewer.getCustomerListArea().setText(customerList);  // Displaying customer list in JTextArea
        } else if (e.getActionCommand().equals("showOrderList")) {
            String orderList = model.getOrderList();
            viewer.getOrderListArea().setText(orderList);  // Displaying order list in JTextArea
        }
    }

    // This method can be removed if not needed anymore
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }
}
