import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Viewer extends JPanel {
    private ResourceBundle resourceBundle;
    private Connection connection;
    private JComboBox<String> options;
    public Viewer() {
        loadResources();

        JFrame frame = new JFrame();
        frame.setTitle("Bookstore Management");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        setSize(800, 600);
        setLayout(new BorderLayout());


        options = new JComboBox<>();
        fillOptions();

        frame.add(options, BorderLayout.NORTH);
        frame.setVisible(true);
    }


    public void loadResources() {
        resourceBundle = ResourceBundle.getBundle("application");
        String URL = resourceBundle.getString("URL");
        String USER = resourceBundle.getString("USER");
        String PASSWORD = resourceBundle.getString("PASSWORD");
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful");
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
}