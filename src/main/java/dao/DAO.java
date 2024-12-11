package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public abstract class DAO {
    private ResourceBundle resources;
    private Connection connection;

    public DAO() {
        loadResource("application");
    }


    public void loadResource(String baseName) {
        try {
            resources = ResourceBundle.getBundle(baseName);
            String URL = resources.getString("URL");
            String USER = resources.getString("USER");
            String PASSWORD = resources.getString("PASSWORD");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established.");
        } catch (MissingResourceException mre) {
            System.err.println(baseName + " resource bundle not found: " + mre.getMessage());
            System.exit(0);
        } catch (SQLException sqle) {
            System.err.println("Database connection error: " + sqle.getMessage());
            System.exit(0);
        }
    }
    public Connection getConnection() {
        return connection;
    }

}
