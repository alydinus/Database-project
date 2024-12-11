import entities.Book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Controller extends MouseAdapter implements ActionListener {
    private Viewer viewer;
    private Model model;

    public Controller(Viewer viewer) {
        this.viewer = viewer;
        this.model = new Model(viewer);
    }

    public void actionPerformed(ActionEvent e) {
        // Handling button actions for creating, updating, deleting, and reading

    }

    // This method can be removed if not needed anymore
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }
}
