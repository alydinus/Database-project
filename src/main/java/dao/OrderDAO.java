package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO extends DAO {

    protected Connection connection;

    // Constructor to initialize the connection
    public OrderDAO() {
        loadResource("application"); // Assuming loadResource initializes the connection
    }

    // Create an order record
    public void createOrder(int customerId, String orderDate) {
        String sql = "INSERT INTO Orders (OrderDate, CustomerID) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, orderDate);
            stmt.setInt(2, customerId);
            stmt.executeUpdate();
            System.out.println("Order added successfully.");
        } catch (SQLException e) {
            System.err.println("Error while adding order: " + e.getMessage());
        }
    }

    // Read an order record by ID
    public void readOrder(int orderId) {
        String sql = "SELECT * FROM Orders WHERE OrderID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Order Details:");
                System.out.println("ID: " + rs.getInt("OrderID"));
                System.out.println("Order Date: " + rs.getDate("OrderDate"));
                System.out.println("Customer ID: " + rs.getInt("CustomerID"));
            } else {
                System.out.println("Order not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while reading order: " + e.getMessage());
        }
    }

    // Update an order record
    public void updateOrder(int orderId, String orderDate) {
        String sql = "UPDATE Orders SET OrderDate = ? WHERE OrderID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, orderDate);
            stmt.setInt(2, orderId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order updated successfully.");
            } else {
                System.out.println("Order not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while updating order: " + e.getMessage());
        }
    }

    // Delete an order record by ID
    public void deleteOrder(int orderId) {
        String sql = "DELETE FROM Orders WHERE OrderID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Order deleted successfully.");
            } else {
                System.out.println("Order not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while deleting order: " + e.getMessage());
        }
    }
}
