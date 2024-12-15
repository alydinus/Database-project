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
            if (e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 100 && e.getY() < 150) {
                viewer.getAuthorsPanel().createAuthor();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 150 && e.getY() < 200) {
                viewer.getAuthorsPanel().deleteAuthor();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 200 && e.getY() < 250) {
                viewer.getAuthorsPanel().updateAuthor();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 250 && e.getY() < 300) {
                viewer.getAuthorsPanel().viewAuthors();
            } else if(e.getX() >= 50 && e.getX() <= 100 && e.getY() >= 450 && e.getY() < 550) {
                viewer.getAuthorsPanel().back();
            }

        } else if (viewer.getSelectedOption().equals("Customers")) {
            if (e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 100 && e.getY() < 150) {
                viewer.getCustomersPanel().createCustomer();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 150 && e.getY() < 200) {
                viewer.getCustomersPanel().deleteCustomer();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 200 && e.getY() < 250) {
                viewer.getCustomersPanel().updateCustomer();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 250 && e.getY() < 300) {
                viewer.getCustomersPanel().viewCustomers();
            } else if(e.getX() >= 50 && e.getX() <= 100 && e.getY() >= 450 && e.getY() < 550) {
                viewer.getCustomersPanel().back();
            }



        } else if (viewer.getSelectedOption().equals("Orders")) {
            if (e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 100 && e.getY() < 150) {
                viewer.getOrdersPanel().createOrder();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 150 && e.getY() < 200) {
                viewer.getOrdersPanel().deleteOrder();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 200 && e.getY() < 250) {
                viewer.getOrdersPanel().updateOrder();
            } else if(e.getX() >= 100 && e.getX() <= 200 && e.getY() >= 250 && e.getY() < 300) {
                viewer.getOrdersPanel().viewOrders();
            } else if(e.getX() >= 50 && e.getX() <= 100 && e.getY() >= 450 && e.getY() < 550) {
                viewer.getOrdersPanel().back();
            }
        }
        if (e.getX() >= 330 && e.getX() <= 380 && e.getY() >= 450 && e.getY() < 500) {
            model.exit();
        }
    }

    public Model getModel() {
        return model;
    }
}
