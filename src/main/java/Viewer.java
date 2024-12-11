import javax.swing.*;

public class Viewer {
    private JPanel login;
    private Controller controller;
    private JFrame frame;
    private Register register;
    private JTextField bookIsbnField;
    private JTextField bookTitleField;
    private JTextField bookYearField;
    private JTextField bookPriceField;

    public Viewer() {
        controller = new Controller(this);
        login = new Login(this);
        register = new Register(this);


        frame = new JFrame("Book store management system");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.add(login);


        frame.setVisible(true);

    }

    public Login getLogin() {
        return (Login) login;
    }
    public Register getRegister() {
        return register;
    }
    public Controller getController() {
        return controller;
    }
    public void showRegister() {
        login.setVisible(false);
        login.setFocusable(false);
        register.setVisible(true);
        frame.add(register);
    }
}
