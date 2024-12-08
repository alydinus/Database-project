import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Login extends JPanel {
    private Image background;
    private JTextField username;
    private JTextField password;
    private ResourceBundle resources;
    private String URL;
    private String USER;
    private String PASSWORD;
    private Connection connection;
    private JComboBox<String> comboBox;
    private JButton confirmButton;

    public void loadResource(String baseName) {
        try {
            resources = ResourceBundle.getBundle(baseName);
            URL = resources.getString("URL");
            USER = resources.getString("USER");
            PASSWORD = resources.getString("PASSWORD");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (MissingResourceException mre) {
            System.err.println(baseName + " not found");
            System.exit(0);
        } catch (SQLException sqle) {
            System.err.println("Error: " + sqle);
        }
    }


    public Login(Viewer viewer) {
        loadResource("application");


        setLayout(null);

        comboBox = new JComboBox<>();
        comboBox.addItem("Admins");
        comboBox.addItem("Users");
        comboBox.setBounds(300, 150, 200, 30);

        username = new JTextField();
        username.setBounds(300, 200, 200, 30);

        password = new JTextField();
        password.setBounds(300, 250, 200, 30);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(300, 300, 200, 30);
        confirmButton.addActionListener(viewer.getController());
        confirmButton.setFocusable(false);

        try {
            URL resource = getClass().getResource("images/background.png");
            if (resource != null) {
                background = ImageIO.read(resource);
            } else {
                System.out.println("Error: Resource not found");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        add(comboBox);
        add(username);
        add(password);
        add(confirmButton);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, 800, 600, this);
        }
    }


    public void checkLogin() {
        String usernameText = username.getText();
        String passwordText = password.getText();

        try {
            authentification(checkRole(), usernameText, passwordText);
        } catch (SQLException sqle) {
            System.err.println("Error: " + sqle);
        }

    }

    private String checkRole() {
        return (String) comboBox.getSelectedItem();
    }

    private void authentification(String role, String usernameInput, String passwordInput) throws SQLException {
        String query = "SELECT * FROM " + role + " WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usernameInput);
        preparedStatement.setString(2, passwordInput);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            if (username.equals(usernameInput) && password.equals(passwordInput)) {
                JOptionPane.showMessageDialog(this, "Correct username and password");
            }
        } else {
            System.out.println("Invalid username or password");
        }
    }

}