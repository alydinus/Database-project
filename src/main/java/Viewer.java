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

        frame = new JFrame("Book Store Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.add(login);
        frame.setVisible(true);
    }

    public Login getLogin() {
        return (Login) login;
    }

    public Register getRegister() {
        return register;
    }

    public Controller getController() {
        return controller;
    }

    public void showRegister() {
        login.setVisible(false);
        login.setFocusable(false);
        register.setVisible(true);
        frame.add(register);
    }

    // Book-related getters
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

    // Author-related getters
    public JTextField getAuthorIdField() {
        return authorIdField;
    }

    public JTextField getAuthorFirstNameField() {
        return authorFirstNameField;
    }

    public JTextField getAuthorLastNameField() {
        return authorLastNameField;
    }

    // Customer-related getters
    public JTextField getCustomerIdField() {
        return customerIdField;
    }

    public JTextField getCustomerNameField() {
        return customerNameField;
    }

    public JTextField getCustomerAddressField() {
        return customerAddressField;
    }
}
