import javax.swing.JFrame;

public class Viewer {
    private Login login;
    private Controller controller;

    public Viewer() {
        controller = new Controller(this);
        login = new Login(this);


        JFrame frame = new JFrame("Book store management system");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.add(login);


        frame.setVisible(true);

    }

    public Login getLogin() {
        return login;
    }
    public Controller getController() {
        return controller;
    }
    public void checkLogin() {
        login.checkLogin();
    }
}
