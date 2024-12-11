import javax.swing.*;
import java.awt.*;

public class Viewer {
    private JPanel login;
    private Controller controller;
    private JFrame frame;
    private Register register;

    // Book-related fields
    private JTextField bookIsbnField;
    private JTextField bookTitleField;
    private JTextField bookYearField;
    private JTextField bookPriceField;

    // Author-related fields
    private JTextField authorIdField;
    private JTextField authorFirstNameField;
    private JTextField authorLastNameField;

    // Customer-related fields
    private JTextField customerIdField;
    private JTextField customerNameField;
    private JTextField customerAddressField;

    // Panels for different sections
    private JPanel bookPanel;
    private JPanel authorPanel;
    private JPanel customerPanel;

    private JPanel mainPanel;

    public Viewer() {
        controller = new Controller(this);
        login = new Login(this);
        register = new Register(this);

        // Initializing the fields
        bookIsbnField = new JTextField(20);
        bookTitleField = new JTextField(20);
        bookYearField = new JTextField(4);
        bookPriceField = new JTextField(8);

        authorIdField = new JTextField(10);
        authorFirstNameField = new JTextField(20);
        authorLastNameField = new JTextField(20);

        customerIdField = new JTextField(10);
        customerNameField = new JTextField(30);
        customerAddressField = new JTextField(50);

        // Frame initialization
        frame = new JFrame("Book Store Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Initialize Panels
        mainPanel = new JPanel(new CardLayout()); // Using CardLayout to switch between panels

        // Initializing section panels
        bookPanel = createBookPanel();
        authorPanel = createAuthorPanel();
        customerPanel = createCustomerPanel();

        // Add panels to the main panel
        mainPanel.add(login, "Login");
        mainPanel.add(register, "Register");
        mainPanel.add(bookPanel, "Book Management");
        mainPanel.add(authorPanel, "Author Management");
        mainPanel.add(customerPanel, "Customer Management");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void showRegister() {
        switchPanel("Register");
    }

    public void showBookManagement() {
        switchPanel("Book Management");
    }

    public void showAuthorManagement() {
        switchPanel("Author Management");
    }

    public void showCustomerManagement() {
        switchPanel("Customer Management");
    }

    private void switchPanel(String panelName) {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, panelName);
    }

    // This method will be triggered after successful login
    public void onLoginSuccess() {
        // Hide login and show book management (or other sections)
        switchPanel("Book Management");  // You can change this to the first section you'd like to show after login
    }

    // Book Panel Creation
    private JPanel createBookPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2)); // Book form layout

        panel.add(new JLabel("ISBN:"));
        panel.add(bookIsbnField);

        panel.add(new JLabel("Title:"));
        panel.add(bookTitleField);

        panel.add(new JLabel("Year:"));
        panel.add(bookYearField);

        panel.add(new JLabel("Price:"));
        panel.add(bookPriceField);

        // Buttons for actions
        JButton createBookButton = new JButton("Create Book");
        panel.add(createBookButton);
        createBookButton.addActionListener(controller);

        return panel;
    }

    // Author Panel Creation
    private JPanel createAuthorPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Author ID:"));
        panel.add(authorIdField);

        panel.add(new JLabel("First Name:"));
        panel.add(authorFirstNameField);

        panel.add(new JLabel("Last Name:"));
        panel.add(authorLastNameField);

        // Button for author creation
        JButton createAuthorButton = new JButton("Create Author");
        panel.add(createAuthorButton);
        createAuthorButton.addActionListener(controller);

        return panel;
    }

    // Customer Panel Creation
    private JPanel createCustomerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Customer ID:"));
        panel.add(customerIdField);

        panel.add(new JLabel("Name:"));
        panel.add(customerNameField);

        panel.add(new JLabel("Address:"));
        panel.add(customerAddressField);

        // Button for customer creation
        JButton createCustomerButton = new JButton("Create Customer");
        panel.add(createCustomerButton);
        createCustomerButton.addActionListener(controller);

        return panel;
    }

    // Getters for fields (Book, Author, Customer)
    public JTextField getBookIsbnField() { return bookIsbnField; }
    public JTextField getBookTitleField() { return bookTitleField; }
    public JTextField getBookYearField() { return bookYearField; }
    public JTextField getBookPriceField() { return bookPriceField; }

    public JTextField getAuthorIdField() { return authorIdField; }
    public JTextField getAuthorFirstNameField() { return authorFirstNameField; }
    public JTextField getAuthorLastNameField() { return authorLastNameField; }

    public JTextField getCustomerIdField() { return customerIdField; }
    public JTextField getCustomerNameField() { return customerNameField; }
    public JTextField getCustomerAddressField() { return customerAddressField; }

    // Access to the controller
    public Controller getController() {
        return controller;
    }

    // Getters for other components
    public Login getLogin() {
        return (Login) login;
    }

    public Register getRegister() {
        return register;
    }

    public JFrame getFrame() {
        return frame;
    }
}
