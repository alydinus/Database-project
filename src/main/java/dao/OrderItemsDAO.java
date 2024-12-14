package dao;

import entities.OrderItem;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsDAO extends DAO {
    protected Connection connection;


    public OrderItemsDAO() {
        loadResource("application");
        connection = getConnection();
    }

    // Create an order item
    public void createOrderItem(String bookIsbn, int quantity) {
        String sql = "INSERT INTO order_items (BookISBN, Quantity) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, bookIsbn);
            stmt.setInt(2, quantity);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Order item added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Such book does not exist");
        }
    }

    // Read order items by order ID
    public List<OrderItem> readOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        String sql = "SELECT * FROM Order_Items";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrderItem orderItem = new OrderItem(rs.getInt("OrderID"), rs.getString("BookISBN"), rs.getInt("Quantity"));
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            System.err.println("Error while reading order items: " + e.getMessage());
        }
        return orderItems;
    }

    // Update an order item by order ID and book ISBN
    public void updateOrderItem(int orderId, String bookIsbn, int quantity) {
        String sql = "UPDATE Order_Items SET Quantity = ? WHERE OrderID = ? AND BookISBN = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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

    // Delete an order item by order ID and book ISBN
    public void deleteOrderItem(int orderId) {
        String sql = "DELETE FROM order_items WHERE OrderID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Order item deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Order item not found");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Such order does not exist");
        }
    }

    public boolean exists(int id) {
        String sql = "SELECT * FROM order_items WHERE OrderID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error while checking if order exists: " + e.getMessage());
            return false;
        }
    }
}
