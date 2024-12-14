import entities.OrderItem;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class OrdersPanel extends JPanel {

    private Viewer viewer;
    private Model model;

    private Image background;

    private JTextField orderIdField;
    private JTextField bookIsbnField;
    private JTextField quantityField;

    public OrdersPanel(Viewer viewer, Model model) {
        this.viewer = viewer;
        this.model = model;

        background = viewer.getBackgroundImage();

        orderIdField = new JTextField();
        bookIsbnField = new JTextField();
        quantityField = new JTextField();

        addMouseListener(viewer.getController());

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 800, 600, this);
        g.setColor(Color.WHITE);
        g.setFont(viewer.getFont());
        g.drawString("Add order", 100, 150);
        g.drawString("Delete order", 100, 200);
        g.drawString("Update order", 100, 250);
        g.drawString("View orders", 100, 300);
        g.drawString("Back", 50, 500);
    }

    public void createOrder() {
        Object[] fields = {
                "Book ISBN", bookIsbnField,
                "Quantity", quantityField
        };

        try {
            JOptionPane.showConfirmDialog(this, fields, "Add order", JOptionPane.OK_CANCEL_OPTION);
            model.createOrderItem(bookIsbnField.getText(), Integer.parseInt(quantityField.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void updateOrder() {
        Object[] fields = {
                "Book ID", bookIsbnField,
                "Quantity", quantityField
        };
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter order id to update:"));
            if (model.orderExists(id)) {
                JOptionPane.showConfirmDialog(this, fields, "Update order", JOptionPane.OK_CANCEL_OPTION);
                model.updateOrderItem(id, bookIsbnField.getText(), Integer.parseInt(quantityField.getText()));
            } else {
                JOptionPane.showMessageDialog(this, "Order does not exist");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void deleteOrder() {

        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter order id to delete:"));
            if (model.orderExists(id)) {
                model.deleteOrderItem(id);
            } else {
                JOptionPane.showMessageDialog(this, "Order does not exist");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }


    }

    public void viewOrders() {
        JComboBox<String> orders = new JComboBox<>();
        for (OrderItem order : model.showOrderItems()) {
            orders.addItem(order.getOrderID() + " " + order.getBookISBN() + " " + order.getQuantity());
        }
        JOptionPane.showConfirmDialog(this, orders, "Orders", JOptionPane.DEFAULT_OPTION);
    }

    public void back() {
        setVisible(false);
        viewer.setVisible(true);
    }


}
