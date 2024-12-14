package dao;

import entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends DAO {

    protected Connection connection;

    // Constructor to initialize the connection
    public CustomerDAO() {
        loadResource("application");
        connection = getConnection();
    }

    // Create a customer record
    public void createCustomer(String name, String address) {
        String sql = "INSERT INTO Customer (Name, Address) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.executeUpdate();
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            System.err.println("Error while adding customer: " + e.getMessage());
        }
    }

    // Read a single customer record by ID
    public Customer readCustomer(int customerId) {
        String sql = "SELECT * FROM Customer WHERE CustomerID = ?";
        Customer customer = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Name"),
                        rs.getString("Address")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error while reading customer: " + e.getMessage());
        }
        return customer;
    }

    // Read all customers (returns a list of customers)
    public List<Customer> readCustomers() {
        String sql = "SELECT * FROM Customer";
        List<Customer> customers = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Name"),
                        rs.getString("Address")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.err.println("Error while reading customers: " + e.getMessage());
        }
        return customers;
    }

    // Update a customer record
    public void updateCustomer(int customerId, String name, String address) {
        String sql = "UPDATE Customer SET Name = ?, Address = ? WHERE CustomerID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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

    // Delete a customer record by ID
    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM Customer WHERE CustomerID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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

    public boolean idExists(int customerId) {
        try {
            String sql = "SELECT * FROM Customer WHERE CustomerID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);

            ResultSet resultSet = statement.executeQuery();
            boolean exists = resultSet.next();

            resultSet.close();
            statement.close();
            return exists;

        } catch (SQLException sqlException) {
            System.out.println("Customer with such ID doesn't exist.");
        }
        return false;
    }
}