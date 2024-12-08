
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends Frame{
    private JTextField username;
    private JTextField password;
    private JButton registerButton;
    private JComboBox<String> comboBox;

    public Register(Viewer viewer) {
        super();
        setLayout(null);


        comboBox = new JComboBox<>();
        comboBox.addItem("Admins");
        comboBox.addItem("Users");
        comboBox.setBounds(300, 100, 200, 30);

        username = new JTextField();
        username.setBounds(300, 200, 200, 30);

        password = new JTextField();
        password.setBounds(300, 280, 200, 30);


        registerButton = new JButton("Register");
        registerButton.setBounds(300, 350, 200, 30);
        registerButton.setActionCommand("register");
        registerButton.addActionListener(viewer.getController());
        registerButton.setFocusable(false);




        add(comboBox);
        add(password);
        add(username);
        add(registerButton);





    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.setFont(font);
        g.drawString("Username", 340, 190);
        g.drawString("Password", 340, 270);

    }

    public void register() {
        String nameToAdd = username.getText();
        String passwordToAdd = password.getText();
        if (comboBox.getSelectedItem().equals("Admins")) {
            addAdmin(nameToAdd, passwordToAdd);
            JOptionPane.showMessageDialog(this, "Admin added successfully");
        } else {
            addUser(nameToAdd, passwordToAdd);
        }
    }
    private void addAdmin(String name, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO admins (username, password) VALUES (?, ?)");
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println("Error: " + sqle);
        }
    }

    private void addUser(String name, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println("Error: " + sqle);
        }
    }

}
