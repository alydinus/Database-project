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

    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (viewer.getSelectedOption().equals("Books")) {
            if (e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 100 && e.getY() < 150) {
                viewer.getBooksPanel().createBook();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 150 && e.getY() < 200) {
                viewer.getBooksPanel().deleteBook();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 200 && e.getY() < 250) {
                viewer.getBooksPanel().updateBook();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 250 && e.getY() < 300) {
                viewer.getBooksPanel().viewBooks();
            } else if(e.getX() >= 50 && e.getX() <= 100 && e.getY() >= 450 && e.getY() < 550) {
                viewer.getBooksPanel().back();
            }
        } else if (viewer.getSelectedOption().equals("Authors")) {

        } else if (viewer.getSelectedOption().equals("Customers")) {

        } else if (viewer.getSelectedOption().equals("Orders")) {

        }
    }

    public Model getModel() {
        return model;
    }
}
