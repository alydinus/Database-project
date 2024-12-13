package dao;

import java.sql.*;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class AuthorDAO extends DAO {
    protected Connection connection;

    public AuthorDAO() {
        loadResource("application");
    }

    // Create author
    public void createAuthor(String name, String surname) {
        String query = "INSERT INTO Author (Name, Surname) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.executeUpdate();
            System.out.println("Author added successfully.");
        } catch (SQLException sqle) {
            System.err.println("Error creating author: " + sqle.getMessage());
        }
    }

    // Read author
    public void readAuthor(int authorId) {
        String query = "SELECT * FROM Author WHERE AuthorID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, authorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Author Details:");
                System.out.println("ID: " + resultSet.getInt("AuthorID"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Surname: " + resultSet.getString("Surname"));
            } else {
                System.out.println("Author not found.");
            }
        } catch (SQLException sqle) {
            System.err.println("Error reading author: " + sqle.getMessage());
        }
    }

    // Update author
    public void updateAuthor(int authorId, String name, String surname) {
        String query = "UPDATE Author SET Name = ?, Surname = ? WHERE AuthorID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, authorId);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Author updated successfully.");
            } else {
                System.out.println("Author not found.");
            }
        } catch (SQLException sqle) {
            System.err.println("Error updating author: " + sqle.getMessage());
        }
    }

    // Delete author
    public void deleteAuthor(int authorId) {
        String query = "DELETE FROM Author WHERE AuthorID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, authorId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Author deleted successfully.");
            } else {
                System.out.println("Author not found.");
            }
        } catch (SQLException sqle) {
            System.err.println("Error deleting author: " + sqle.getMessage());
        }
    }

    // Get the current connection (optional utility)
    public Connection getConnection() {
        return connection;
    }
}
