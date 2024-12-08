import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Frame {
    private Image background;
    private JTextField username;
    private JTextField password;
    private Connection connection;
    private JComboBox<String> comboBox;
    private JButton confirmButton;


    public Login(Viewer viewer) {

        connection = getConnection();

        setLayout(null);
        addMouseListener(viewer.getController());

        comboBox = new JComboBox<>();
        comboBox.addItem("Admins");
        comboBox.addItem("Users");
        comboBox.setBounds(300, 150, 200, 30);

        username = new JTextField();
        username.setBounds(300, 200, 200, 30);

        password = new JTextField();
        password.setBounds(300, 250, 200, 30);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(300, 300, 200, 30);
        confirmButton.addActionListener(viewer.getController());
        confirmButton.setFocusable(false);
        confirmButton.setActionCommand("login");



        add(comboBox);
        add(username);
        add(password);
        add(confirmButton);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.setFont(font);
        g.drawString("Register", 350, 500);
    }


    public void checkLogin() {
        String usernameText = username.getText();
        String passwordText = password.getText();

        try {
            authentification(checkRole(), usernameText, passwordText);
        } catch (SQLException sqle) {
            System.err.println("Error: " + sqle);
        }

    }

    private String checkRole() {
        return (String) comboBox.getSelectedItem();
    }

    private void authentification(String role, String usernameInput, String passwordInput) throws SQLException {
        String query = "SELECT * FROM " + role + " WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usernameInput);
        preparedStatement.setString(2, passwordInput);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            if (username.equals(usernameInput) && password.equals(passwordInput)) {
                JOptionPane.showMessageDialog(this, "Correct username and password");
            }
        } else {
            System.out.println("Invalid username or password");
        }
    }

    public boolean isRegisterClicked(MouseEvent event) {
        int x1 = event.getX();
        int y1 = event.getY();


        if (350 <= x1 && x1 <= 450 && 480 <= y1 && y1 <= 550) {
            return true;
        }
        return false;
    }


}