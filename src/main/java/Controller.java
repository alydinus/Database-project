import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Viewer viewer;
    private Model model;

    public Controller(Viewer viewer) {
        this.viewer = viewer;
        this.model = new Model(viewer);
    }

    public void actionPerformed(ActionEvent e) {
        viewer.checkLogin();
    }
}
