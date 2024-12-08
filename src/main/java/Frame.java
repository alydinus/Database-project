import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Frame extends JPanel{
    protected ResourceBundle resources;
    protected Connection connection;
    protected Image background;
    protected Font font;
    protected Color color;

    public Frame() {
        loadResource("application");
        background = getBackground("images/background.png");
        font = new Font("Arial", Font.PLAIN, 25);
        color = new Color(255, 255, 255);
    }

    public void loadResource(String baseName) {
        try {
            resources = ResourceBundle.getBundle(baseName);
            String URL = resources.getString("URL");
            String USER = resources.getString("USER");
            String PASSWORD = resources.getString("PASSWORD");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (MissingResourceException mre) {
            System.err.println(baseName + " not found");
            System.exit(0);
        } catch (SQLException sqle) {
            System.err.println("Error: " + sqle);
        }
    }
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            System.err.println("Error: " + sqle);
        }
    }
    public Image getBackground(String path) {
        try {
            java.net.URL resource = getClass().getResource(path);
            if (resource != null) {
                background = ImageIO.read(resource);
                return background;
            } else {
                System.out.println("Error: Resource not found");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public Image getBackgroundImage() {
        return background;
    }
    public ResourceBundle getResources() {
        return resources;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 800, 600, this);
    }
}
