import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter implements ActionListener {
    private Viewer viewer;
    private Model model;

    public Controller(Viewer viewer) {
        this.viewer = viewer;
        this.model = new Model(viewer);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login")) {
            viewer.getLogin().checkLogin();
        } else if (e.getActionCommand().equals("register")) {
            viewer.getRegister().register();
        }

    }

    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (viewer.getLogin().isRegisterClicked(e)){
            viewer.showRegister();
        }


    }


}
