import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Viewer extends JPanel{
    private Model model;

    private Font font;

    private ResourceBundle resourceBundle;
    private Connection connection;
    private Image background;
    private Controller controller;
    private JFrame frame;
    private BooksPanel booksPanel;
    private AuthorPanel authorsPanel;
    private OrdersPanel ordersPanel;
    private CustomerPanel customersPanel;

    private JComboBox<String> options;
    private JButton chooseButton;

    public Viewer() {
        loadResources();
        controller = new Controller(this);

        model = controller.getModel();

        font = new Font("Arial", Font.BOLD, 25);


        frame = new JFrame("Online Bookstore Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);



        setLayout(null);
        addMouseListener(controller);
        background = getBackgroundImage();
        font = getFont();


        String[] optionsArray = {"Books", "Orders", "Authors", "Customers"};
        options = new JComboBox<>(optionsArray);
        options.setBounds(300, 200, 200, 30);

        chooseButton = new JButton("Choose");
        chooseButton.setBounds(350, 250, 100, 30);
        chooseButton.addActionListener(controller);
        chooseButton.setActionCommand("choose");
        chooseButton.setFocusable(false);

        add(chooseButton);
        add(options);
        frame.add(this);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 800, 600, this);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Welcome to the Online Bookstore Management System", 100, 100);
        g.drawString("Please select an option from the menu", 130, 150);
        g.drawString("Exit", 350, 500);
    }


    public void loadResources() {
        resourceBundle = ResourceBundle.getBundle("application");
        try {
            String USER = resourceBundle.getString("USER");
            String PASSWORD = resourceBundle.getString("PASSWORD");
            String URL = resourceBundle.getString("URL");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException sqlException) {
            System.out.println("Error: " + sqlException.getMessage());
        }
    }

    public Image getBackgroundImage() {
        try {
            java.net.URL resource = getClass().getResource("images/background.png");
            if (resource != null) {
                background = ImageIO.read(resource);
                return background;
            } else {
                System.out.println("Resource not found: " + "images/background.png");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }


    public Font getFont() {
        return font;
    }

    public String getSelectedOption() {
        return (String) options.getSelectedItem();
    }

    public Controller getController() {
        return controller;
    }

    public void showBooks() {
        booksPanel = new BooksPanel(this, model);
        setVisible(false);
        frame.add(booksPanel);
    }

    public void showAuthors() {
        authorsPanel = new AuthorPanel(this, model);
        setVisible(false);
        frame.add(authorsPanel);
    }

    public void showOrders() {
        ordersPanel = new OrdersPanel(this, model);
        setVisible(false);
        frame.add(ordersPanel);
    }

    public void showCustomers() {
        customersPanel = new CustomerPanel(this, model);
        setVisible(false);
        frame.add(customersPanel);
    }

    public BooksPanel getBooksPanel() {
        return booksPanel;
    }

    public AuthorPanel getAuthorsPanel() {
        return authorsPanel;
    }

    public OrdersPanel getOrdersPanel() {
        return ordersPanel;
    }

    public CustomerPanel getCustomersPanel() {
        return customersPanel;
    }





}