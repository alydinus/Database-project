import entities.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Controller extends MouseAdapter implements ActionListener {
    private Viewer viewer;
    private Model model;

    public Controller(Viewer viewer) {
        this.viewer = viewer;
        this.model = new Model(viewer);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("choose")) {
            if (viewer.getSelectedOption().equals("Books")) {
                viewer.showBooks();
            } else if (viewer.getSelectedOption().equals("Authors")) {
                viewer.showAuthors();
            } else if (viewer.getSelectedOption().equals("Customers")) {
                viewer.showCustomers();
            } else if (viewer.getSelectedOption().equals("Orders")) {
                viewer.showOrders();
            }
    }
    }

    // This method can be removed if not needed anymore
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }
}
