import entities.Customer;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class CustomerPanel extends JPanel {
    private Viewer viewer;
    private Model model;
    private Font font;
    private Image background;
    private JTextField customerIdField;
    private JTextField nameField;
    private JTextField addressField;

    public CustomerPanel(Viewer viewer, Model model) {
        this.viewer = viewer;
        this.model = model;
        font = viewer.getFont();
        background = viewer.getBackgroundImage();
        addMouseListener(viewer.getController());

        customerIdField = new JTextField();
        nameField = new JTextField();
        addressField = new JTextField();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 800, 600, this);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Add customer", 100, 150);
        g.drawString("Delete customer", 100, 200);
        g.drawString("Update customer", 100, 250);
        g.drawString("View customers", 100, 300);
        g.drawString("Back", 50, 500);
    }

    public void createCustomer() {
        Object[] fields = {
                "Customer ID", customerIdField,
                "Name", nameField,
                "Address", addressField
        };
        try {
            JOptionPane.showConfirmDialog(this, fields, "Add customer", JOptionPane.OK_CANCEL_OPTION);
            model.createCustomer(nameField.getText(), addressField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void updateCustomer() {
        Object[] fields = {
                "Name", nameField,
                "Address", addressField
        };
        try {
            int customerId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Customer ID to update"));
            if (model.customerExists(customerId)) {
                JOptionPane.showConfirmDialog(this, fields, "Update customer", JOptionPane.OK_CANCEL_OPTION);
                model.updateCustomer(customerId, nameField.getText(), addressField.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Customer with ID " + customerId + " does not exist.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void deleteCustomer() {
        try {
            int customerId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Customer ID to delete"));
            if (model.customerExists(customerId)) {
                model.deleteCustomer(customerId);
            } else {
                JOptionPane.showMessageDialog(this, "Customer with ID " + customerId + " does not exist.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void viewCustomers() {
        JComboBox<String> customers = new JComboBox<>();
        for (Customer customer : model.showAllCustomers()) {
            customers.addItem(customer.getName() + " - " + customer.getAddress());
        }
        JOptionPane.showConfirmDialog(this, customers, "Customers", JOptionPane.DEFAULT_OPTION);
    }

    public void back() {
        setVisible(false);
        viewer.setVisible(true);
    }
}