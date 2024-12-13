package dao;

import entities.Author;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO extends DAO {
    protected Connection connection;

    public AuthorDAO() {
        loadResource("application");
        connection = getConnection();
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
    public List<Author> showAuthors() {
        List<Author> authors = new ArrayList<>();
        String query = "SELECT * FROM Author";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author(
                        resultSet.getInt("AuthorID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname")
                );
                authors.add(author);
            }
        } catch (SQLException sqle) {
            System.err.println("Error reading author: " + sqle.getMessage());
        }
        return authors;
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


    public boolean idExists(int id) {
        try {
            String sql = "SELECT * FROM author WHERE authorid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Such author does not exists.");
        }
        return false;
    }
}
