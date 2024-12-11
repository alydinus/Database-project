import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Viewer extends JFrame {
    private JTextField bookIsbnField, bookTitleField, bookYearField, bookPriceField;
    private JTextArea bookListArea;
    private JTextField authorIdField, authorFirstNameField, authorLastNameField;
    private JTextArea authorListArea;
    private JTextField customerIdField, customerNameField, customerAddressField;
    private JTextArea customerListArea;
    private JTextField orderIdField, customerIdFieldForOrder, orderDateField;
    private JTextArea orderListArea;

    private JButton createBookButton, updateBookButton, deleteBookButton, showBookListButton;
    private JButton createAuthorButton, updateAuthorButton, deleteAuthorButton, showAuthorListButton;
    private JButton createCustomerButton, updateCustomerButton, deleteCustomerButton, showCustomerListButton;
    private JButton createOrderButton, updateOrderButton, deleteOrderButton, showOrderListButton;

    public Viewer() {
        setTitle("Bookstore Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panels for book actions
        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(new GridLayout(5, 2));
        bookPanel.add(new JLabel("ISBN:"));
        bookIsbnField = new JTextField();
        bookPanel.add(bookIsbnField);
        bookPanel.add(new JLabel("Title:"));
        bookTitleField = new JTextField();
        bookPanel.add(bookTitleField);
        bookPanel.add(new JLabel("Year:"));
        bookYearField = new JTextField();
        bookPanel.add(bookYearField);
        bookPanel.add(new JLabel("Price:"));
        bookPriceField = new JTextField();
        bookPanel.add(bookPriceField);

        createBookButton = new JButton("Create Book");
        updateBookButton = new JButton("Update Book");
        deleteBookButton = new JButton("Delete Book");
        showBookListButton = new JButton("Show Book List");

        bookPanel.add(createBookButton);
        bookPanel.add(updateBookButton);
        bookPanel.add(deleteBookButton);
        bookPanel.add(showBookListButton);

        // Panel for book list
        bookListArea = new JTextArea();
        bookListArea.setEditable(false);
        JScrollPane bookScrollPane = new JScrollPane(bookListArea);

        // Panels for author actions
        JPanel authorPanel = new JPanel();
        authorPanel.setLayout(new GridLayout(4, 2));
        authorPanel.add(new JLabel("Author ID:"));
        authorIdField = new JTextField();
        authorPanel.add(authorIdField);
        authorPanel.add(new JLabel("First Name:"));
        authorFirstNameField = new JTextField();
        authorPanel.add(authorFirstNameField);
        authorPanel.add(new JLabel("Last Name:"));
        authorLastNameField = new JTextField();
        authorPanel.add(authorLastNameField);

        createAuthorButton = new JButton("Create Author");
        updateAuthorButton = new JButton("Update Author");
        deleteAuthorButton = new JButton("Delete Author");
        showAuthorListButton = new JButton("Show Author List");

        authorPanel.add(createAuthorButton);
        authorPanel.add(updateAuthorButton);
        authorPanel.add(deleteAuthorButton);
        authorPanel.add(showAuthorListButton);

        // Panel for author list
        authorListArea = new JTextArea();
        authorListArea.setEditable(false);
        JScrollPane authorScrollPane = new JScrollPane(authorListArea);

        // Panels for customer actions
        JPanel customerPanel = new JPanel();
        customerPanel.setLayout(new GridLayout(4, 2));
        customerPanel.add(new JLabel("Customer ID:"));
        customerIdField = new JTextField();
        customerPanel.add(customerIdField);
        customerPanel.add(new JLabel("Name:"));
        customerNameField = new JTextField();
        customerPanel.add(customerNameField);
        customerPanel.add(new JLabel("Address:"));
        customerAddressField = new JTextField();
        customerPanel.add(customerAddressField);

        createCustomerButton = new JButton("Create Customer");
        updateCustomerButton = new JButton("Update Customer");
        deleteCustomerButton = new JButton("Delete Customer");
        showCustomerListButton = new JButton("Show Customer List");

        customerPanel.add(createCustomerButton);
        customerPanel.add(updateCustomerButton);
        customerPanel.add(deleteCustomerButton);
        customerPanel.add(showCustomerListButton);

        // Panel for customer list
        customerListArea = new JTextArea();
        customerListArea.setEditable(false);
        JScrollPane customerScrollPane = new JScrollPane(customerListArea);

        // Panels for order actions
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new GridLayout(4, 2));
        orderPanel.add(new JLabel("Order ID:"));
        orderIdField = new JTextField();
        orderPanel.add(orderIdField);
        orderPanel.add(new JLabel("Customer ID:"));
        customerIdFieldForOrder = new JTextField();
        orderPanel.add(customerIdFieldForOrder);
        orderPanel.add(new JLabel("Order Date:"));
        orderDateField = new JTextField();
        orderPanel.add(orderDateField);

        createOrderButton = new JButton("Create Order");
        updateOrderButton = new JButton("Update Order");
        deleteOrderButton = new JButton("Delete Order");
        showOrderListButton = new JButton("Show Order List");

        orderPanel.add(createOrderButton);
        orderPanel.add(updateOrderButton);
        orderPanel.add(deleteOrderButton);
        orderPanel.add(showOrderListButton);

        // Panel for order list
        orderListArea = new JTextArea();
        orderListArea.setEditable(false);
        JScrollPane orderScrollPane = new JScrollPane(orderListArea);

        // Adding all panels and areas to the frame
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2));
        topPanel.add(bookPanel);
        topPanel.add(authorPanel);
        topPanel.add(customerPanel);
        topPanel.add(orderPanel);

        add(topPanel, BorderLayout.NORTH);
        add(bookScrollPane, BorderLayout.WEST);
        add(authorScrollPane, BorderLayout.CENTER);
        add(customerScrollPane, BorderLayout.EAST);
        add(orderScrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JTextField getBookIsbnField() {
        return bookIsbnField;
    }

    public JTextField getBookTitleField() {
        return bookTitleField;
    }

    public JTextField getBookYearField() {
        return bookYearField;
    }

    public JTextField getBookPriceField() {
        return bookPriceField;
    }

    public JTextArea getBookListArea() {
        return bookListArea;
    }

    public JTextField getAuthorIdField() {
        return authorIdField;
    }

    public JTextField getAuthorFirstNameField() {
        return authorFirstNameField;
    }

    public JTextField getAuthorLastNameField() {
        return authorLastNameField;
    }

    public JTextArea getAuthorListArea() {
        return authorListArea;
    }

    public JTextField getCustomerIdField() {
        return customerIdField;
    }

    public JTextField getCustomerNameField() {
        return customerNameField;
    }

    public JTextField getCustomerAddressField() {
        return customerAddressField;
    }

    public JTextArea getCustomerListArea() {
        return customerListArea;
    }

    public JTextField getOrderIdField() {
        return orderIdField;
    }

    public JTextField getCustomerIdFieldForOrder() {
        return customerIdFieldForOrder;
    }

    public JTextField getOrderDateField() {
        return orderDateField;
    }

    public JTextArea getOrderListArea() {
        return orderListArea;
    }

    // Methods for adding action listeners
    public void addCreateBookListener(ActionListener listener) {
        createBookButton.addActionListener(listener);
    }

    public void addUpdateBookListener(ActionListener listener) {
        updateBookButton.addActionListener(listener);
    }

    public void addDeleteBookListener(ActionListener listener) {
        deleteBookButton.addActionListener(listener);
    }

    public void addShowBookListListener(ActionListener listener) {
        showBookListButton.addActionListener(listener);
    }

    public void addCreateAuthorListener(ActionListener listener) {
        createAuthorButton.addActionListener(listener);
    }

    public void addUpdateAuthorListener(ActionListener listener) {
        updateAuthorButton.addActionListener(listener);
    }

    public void addDeleteAuthorListener(ActionListener listener) {
        deleteAuthorButton.addActionListener(listener);
    }

    public void addShowAuthorListListener(ActionListener listener) {
        showAuthorListButton.addActionListener(listener);
    }

    public void addCreateCustomerListener(ActionListener listener) {
        createCustomerButton.addActionListener(listener);
    }

    public void addUpdateCustomerListener(ActionListener listener) {
        updateCustomerButton.addActionListener(listener);
    }

    public void addDeleteCustomerListener(ActionListener listener) {
        deleteCustomerButton.addActionListener(listener);
    }

    public void addShowCustomerListListener(ActionListener listener) {
        showCustomerListButton.addActionListener(listener);
    }

    public void addCreateOrderListener(ActionListener listener) {
        createOrderButton.addActionListener(listener);
    }

    public void addUpdateOrderListener(ActionListener listener) {
        updateOrderButton.addActionListener(listener);
    }

    public void addDeleteOrderListener(ActionListener listener) {
        deleteOrderButton.addActionListener(listener);
    }

    public void addShowOrderListListener(ActionListener listener) {
        showOrderListButton.addActionListener(listener);
    }
}
