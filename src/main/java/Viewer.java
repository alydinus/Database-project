import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Viewer extends JPanel {
    private ResourceBundle resourceBundle;
    private Connection connection;
    private JComboBox<String> options;
    private JButton submitButton;




    private JTextField isbnField;
    private JTextField titleField;
    private JTextField publicationYearField;
    private JTextField priceField;


    public Viewer() {
        Controller controller = new Controller(this);
        loadResources();

        JFrame frame = new JFrame();
        frame.setTitle("Bookstore Management");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        setSize(800, 600);
        setLayout(null);


        options = new JComboBox<>();
        options.setBounds(0,0,800, 20);
        options.addActionListener(controller);
        options.setActionCommand("options");
        fillOptions();


        submitButton = new JButton("Submit");
        submitButton.setBounds(0, 50, 100, 20);
        submitButton.addActionListener(controller);
        submitButton.setActionCommand("submit");



        frame.add(submitButton);
        add(options);
        frame.add(this);
        frame.setVisible(true);
    }


    public void loadResources() {
        resourceBundle = ResourceBundle.getBundle("application");
        String URL = resourceBundle.getString("URL");
        String USER = resourceBundle.getString("USER");
        String PASSWORD = resourceBundle.getString("PASSWORD");
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed" + e.getMessage());
        }
    }

    private void fillOptions() {
        options.addItem("Create book");
        options.addItem("Update book");
        options.addItem("Delete book");
        options.addItem("Show all books");

        options.addItem("Create customer");
        options.addItem("Update customer");
        options.addItem("Delete customer");
        options.addItem("Show all customers");

        options.addItem("Create order");
        options.addItem("Update order");
        options.addItem("Delete order");
        options.addItem("Show all orders");

        options.addItem("Retrieve a list of books with their authors.");
        options.addItem("Find the total sales for a specific book.");
        options.addItem("List customers who made more than one purchase.");
        options.addItem("Find the top N best-selling books.");
        options.addItem("Identify authors with the highest total sales.");
        options.addItem("Retrieve customers with the highest total purchase amount.");
        options.addItem("Identify books with low stock.");
        options.addItem("Retrieve the latest orders placed.");
        options.addItem("Calculate total revenue.");
        options.addItem("Identify customers who have not made a purchase.");

    }

    public String getSelectedOption() {
        return (String) options.getSelectedItem();
    }

    public void showCreateBookForm() {
        HashMap<String, String> bookData = new HashMap<>();
        isbnField = new JTextField();
        titleField = new JTextField();
        publicationYearField = new JTextField();
        priceField = new JTextField();

        isbnField.setBounds(100, 100, 200, 20);
        titleField.setBounds(100, 150, 200, 20);
        publicationYearField.setBounds(100, 200, 200, 20);
        priceField.setBounds(100, 250, 200, 20);

        add(isbnField);
        add(titleField);
        add(publicationYearField);
        add(priceField);

        bookData.put("isbn", isbnField.getText());
        bookData.put("title", titleField.getText());
        bookData.put("publicationYear", publicationYearField.getText());
        bookData.put("price", priceField.getText());

        revalidate();

    }

    public String getIsbn() {
        return isbnField.getText();
    }

    public String getTitle() {
        return titleField.getText();
    }

    public int getPublicationYear() {
        return Integer.parseInt(publicationYearField.getText());
    }

    public double getPrice() {
        return Double.parseDouble(priceField.getText());
    }


}