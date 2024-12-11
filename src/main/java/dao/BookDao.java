package dao;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookDao {
    public static void createBook(String isbn, String title, int publicationYear, double price) {
        String sql = "INSERT INTO Book (ISBN, Title, PublicationYear, Price) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, isbn);
            stmt.setString(2, title);
            stmt.setInt(3, publicationYear);
            stmt.setDouble(4, price);
            stmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.err.println("Error while adding book: " + e.getMessage());
        }
    }
    public static void readBook(String isbn) {
        String sql = "SELECT * FROM Book WHERE ISBN = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, isbn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Book Details:");
                System.out.println("ISBN: " + rs.getString("ISBN"));
                System.out.println("Title: " + rs.getString("Title"));
                System.out.println("Publication Year: " + rs.getInt("PublicationYear"));
                System.out.println("Price: " + rs.getDouble("Price"));
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while reading book: " + e.getMessage());
        }
    }

    public static void updateBook(String isbn, String title, int publicationYear, double price) {
        String sql = "UPDATE Book SET Title = ?, PublicationYear = ?, Price = ? WHERE ISBN = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setInt(2, publicationYear);
            stmt.setDouble(3, price);
            stmt.setString(4, isbn);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while updating book: " + e.getMessage());
        }
    }

    public static void deleteBook(String isbn) {
        String sql = "DELETE FROM Book WHERE ISBN = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, isbn);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while deleting book: " + e.getMessage());
        }
    }
}