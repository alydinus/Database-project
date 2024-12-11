package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
    public void createAuthor(String name, String surname) {
        String sql = "INSERT INTO Author (Name, Surname) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.executeUpdate();
            System.out.println("Author added successfully.");
        } catch (SQLException e) {
            System.err.println("Error while adding author: " + e.getMessage());
        }
    }

    public void readAuthor(int authorId) {
        String sql = "SELECT * FROM Author WHERE AuthorID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, authorId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Author Details:");
                System.out.println("ID: " + rs.getInt("AuthorID"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Surname: " + rs.getString("Surname"));
            } else {
                System.out.println("Author not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while reading author: " + e.getMessage());
        }
    }

    public void updateAuthor(int authorId, String name, String surname) {
        String sql = "UPDATE Author SET Name = ?, Surname = ? WHERE AuthorID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setInt(3, authorId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Author updated successfully.");
            } else {
                System.out.println("Author not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while updating author: " + e.getMessage());
        }
    }

    public void deleteAuthor(int authorId) {
        String sql = "DELETE FROM Author WHERE AuthorID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, authorId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Author deleted successfully.");
            } else {
                System.out.println("Author not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while deleting author: " + e.getMessage());
        }
    }
}

