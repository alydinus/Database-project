package dao;

import entities.Admin;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends DAO{
    private Admin admin;
    private Connection connection;


    public AdminDAO() {
        admin = new Admin();
        loadResource("application");
        connection = getConnection();
    }

    public void create(String username, String password) {
        try {
            String query = "INSERT INTO Admins (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Admin added successfully.");
        } catch (SQLException sqle) {
            System.err.println("Admin creation error: " + sqle.getMessage());
        }

    }

    public void update(String username, String password) {
        try {
            String query = "UPDATE Admins SET password = ? WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Admin updated successfully.");
        } catch (SQLException sqle) {
            System.err.println("Admin update error: " + sqle.getMessage());
        }

    }

    public void delete(String username, String password) {
        try {
            String query = "DELETE FROM Admins WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Admin deleted successfully.");
        } catch (SQLException sqle) {
            System.err.println("Admin deletion error: " + sqle.getMessage());
        }

    }

    public List<String> read() {
        List<String> admins = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Admins");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                admins.add(resultSet.getString("username"));
            }
            return admins;
        } catch (SQLException sqle) {
            System.err.println("Admin read error: " + sqle.getMessage());
            return null;
        }


    }

}
