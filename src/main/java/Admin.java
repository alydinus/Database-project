import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.sql.Connection;

public class Admin extends Frame {
    private Connection connection;
    private Model model;
    private JComboBox<String> options;
    public JButton confirmButton;
    private JTextField username;
    private JTextField password;
    public Admin(Viewer viewer, Model model) {
        connection = getConnection();

        this.model = model;


        setLayout(null);
        addMouseListener(viewer.getController());


        options = new JComboBox<>();
        options.addItem("Create");
        options.addItem("Update");
        options.addItem("Delete");
        options.addItem("Read");
        options.addItem("List customers who made more than one purchase.");
        options.addItem("Retrieve customers with the highest total purchase amount.");
        options.addItem("Identify books with low stock.");
        options.addItem("Retrieve the latest orders placed.");
        options.addItem("Calculate total revenue.");
        options.addItem("Identify customers who have not made a purchase.");
        options.setBounds(200, 150, 400, 30);


        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(300, 450, 200, 30);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(viewer.getController());
        confirmButton.setActionCommand("confirmAdmin");


        add(confirmButton);
        add(options);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.setFont(font);

    }

    public void executeOptions() {
        if (options.getSelectedItem().equals("Create")) {
            username = new JTextField();
            username.setBounds(300, 200, 200, 30);
            add(username);


            password = new JTextField();
            password.setBounds(300, 250, 200, 30);
            add(password);
            confirmButton.setActionCommand("createAdmin");
        } else if (options.getSelectedItem().equals("Update")) {
            username = new JTextField();
            username.setBounds(300, 200, 200, 30);
            add(username);

            password = new JTextField();
            password.setBounds(300, 250, 200, 30);
            add(password);
            confirmButton.setActionCommand("updateAdmin");
            model.updateAdmin(username.getText(), password.getText());
        } else if (options.getSelectedItem().equals("Delete")) {
            username = new JTextField();
            username.setBounds(300, 200, 200, 30);
            add(username);

            password = new JTextField();
            password.setBounds(300, 250, 200, 30);
            add(password);
            confirmButton.setActionCommand("deleteAdmin");
        } else if (options.getSelectedItem().equals("Read")) {
            username = new JTextField();
            username.setBounds(300, 200, 200, 30);
            add(username);
            JComboBox<String> admins = new JComboBox<>();
            admins.setBounds(300, 300, 200, 30);
            for (String admin : model.readAdmin()) {
                admins.addItem(admin);
            }
            add(admins);
            confirmButton.setActionCommand("readAdmin");
        }
//        else if (options.getSelectedItem().equals("List customers who made more than one purchase.")) {
//            listCustomersWhoMadeMoreThanOnePurchase();
//        } else if (options.getSelectedItem().equals("Retrieve customers with the highest total purchase amount.")) {
//            retrieveCustomersWithTheHighestTotalPurchaseAmount();
//        } else if (options.getSelectedItem().equals("Identify books with low stock.")) {
//            identifyBooksWithLowStock();
//        } else if (options.getSelectedItem().equals("Retrieve the latest orders placed.")) {
//            retrieveTheLatestOrdersPlaced();
//        } else if (options.getSelectedItem().equals("Calculate total revenue.")) {
//            calculateTotalRevenue();
//        } else if (options.getSelectedItem().equals("Identify customers who have not made a purchase.")) {
//            identifyCustomersWhoHaveNotMadeAPurchase();
//        }



        revalidate();
        repaint();
    }

    public String getAdminName() {
        return username.getText();
    }

    public String getAdminPassword() {
        return password.getText();
    }

}
