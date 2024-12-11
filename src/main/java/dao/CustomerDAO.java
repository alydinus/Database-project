package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    public void createCustomer(String name, String address) {
        String sql = "INSERT INTO Customer (Name, Address) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.executeUpdate();
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            System.err.println("Error while adding customer: " + e.getMessage());
        }
    }

    public void readCustomer(int customerId) {
        String sql = "SELECT * FROM Customer WHERE CustomerID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Customer Details:");
                System.out.println("ID: " + rs.getInt("CustomerID"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Address: " + rs.getString("Address"));
            } else {
                System.out.println("Customer not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while reading customer: " + e.getMessage());
        }
    }

    public void updateCustomer(int customerId, String name, String address) {
        String sql = "UPDATE Customer SET Name = ?, Address = ? WHERE CustomerID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setInt(3, customerId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("Customer not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while updating customer: " + e.getMessage());
        }
    }

    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM Customer WHERE CustomerID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while deleting customer: " + e.getMessage());
        }
    }
}
