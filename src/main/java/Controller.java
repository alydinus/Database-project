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
        if (e.getActionCommand().equals("createBook")) {
            String isbn = viewer.getBookIsbnField().getText();
            String title = viewer.getBookTitleField().getText();
            int publicationYear = Integer.parseInt(viewer.getBookYearField().getText());
            double price = Double.parseDouble(viewer.getBookPriceField().getText());

            model.createBook(isbn, title, publicationYear, price);
        } else if (e.getActionCommand().equals("updateBook")){
            String isbn = viewer.getBookIsbnField().getText();
            String title = viewer.getBookTitleField().getText();
            int publicationYear = Integer.parseInt(viewer.getBookYearField().getText());
            double price = Double.parseDouble(viewer.getBookPriceField().getText());

            model.updateBook(isbn, title, publicationYear, price);
        } else if (e.getActionCommand().equals("deleteBook")){
            String isbn = viewer.getBookIsbnField().getText();
            model.deleteBook(isbn);
        } else if (e.getActionCommand().equals("readBook")){
            String isbn = viewer.getBookIsbnField().getText();
            model.readBook(isbn);
        } else if (e.getActionCommand().equals("createAuthor")){
            String firstName = viewer.getAuthorFirstNameField().getText();
            String lastName = viewer.getAuthorLastNameField().getText();
            model.createAuthor(firstName, lastName);
        } else if (e.getActionCommand().equals("updateAuthor")){
            int authorId = Integer.parseInt(viewer.getAuthorIdField().getText());
            String firstName = viewer.getAuthorFirstNameField().getText();
            String lastName = viewer.getAuthorLastNameField().getText();
            model.updateAuthor(authorId, firstName, lastName);
        } else if (e.getActionCommand().equals("deleteAuthor")){
            int authorId = Integer.parseInt(viewer.getAuthorIdField().getText());
            model.deleteAuthor(authorId);
        } else if (e.getActionCommand().equals("readAuthor")){
            int authorId = Integer.parseInt(viewer.getAuthorIdField().getText());
            model.readAuthor(authorId);
        } else if (e.getActionCommand().equals("createCustomer")){
            String name = viewer.getCustomerNameField().getText();
            String address = viewer.getCustomerAddressField().getText();
            model.createCustomer(name, address);
        } else if (e.getActionCommand().equals("updateCustomer")){
            int customerId = Integer.parseInt(viewer.getCustomerIdField().getText());
            String name = viewer.getCustomerNameField().getText();
            String address = viewer.getCustomerAddressField().getText();
            model.updateCustomer(customerId, name, address);
        } else if (e.getActionCommand().equals("deleteCustomer")){
            int customerId = Integer.parseInt(viewer.getCustomerIdField().getText());
            model.deleteCustomer(customerId);
        }

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
