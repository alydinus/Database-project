package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemsDAO {
    public static void createOrderItem(int orderId, String bookIsbn, int quantity) {
        String sql = "INSERT INTO Order_Items (OrderID, BookISBN, Quantity) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            stmt.setString(2, bookIsbn);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
            System.out.println("Order Item added successfully.");
        } catch (SQLException e) {
            System.err.println("Error while adding order item: " + e.getMessage());
        }
    }

    public static void readOrderItems(int orderId) {
        String sql = "SELECT * FROM Order_Items WHERE OrderID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("OrderID"));
                System.out.println("Book ISBN: " + rs.getString("BookISBN"));
                System.out.println("Quantity: " + rs.getInt("Quantity"));
            }
        } catch (SQLException e) {
            System.err.println("Error while reading order items: " + e.getMessage());
        }
    }

    public static void updateOrderItem(int orderId, String bookIsbn, int quantity) {
        String sql = "UPDATE Order_Items SET Quantity = ? WHERE OrderID = ? AND BookISBN = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, orderId);
            stmt.setString(3, bookIsbn);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order Item updated successfully.");
            } else {
                System.out.println("Order Item not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while updating order item: " + e.getMessage());
        }
    }

    public static void deleteOrderItem(int orderId, String bookIsbn) {
        String sql = "DELETE FROM Order_Items WHERE OrderID = ? AND BookISBN = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            stmt.setString(2, bookIsbn);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Order Item deleted successfully.");
            } else {
                System.out.println("Order Item not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while deleting order item: " + e.getMessage());
        }
    }
}
