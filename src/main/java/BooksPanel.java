import entities.Book;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class BooksPanel extends JPanel {
    private Viewer viewer;
    private Model model;
    private Font font;
    private Image background;
    private JTextField isbnField;
    private JTextField titleField;
    private JTextField publicationYearField;
    private JTextField priceField;

    public BooksPanel(Viewer viewer, Model model) {
        this.viewer = viewer;
        this.model = model;
        font = viewer.getFont();
        background = viewer.getBackgroundImage();
        addMouseListener(viewer.getController());


        isbnField = new JTextField();
        titleField = new JTextField();
        publicationYearField = new JTextField();
        priceField = new JTextField();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 800, 600, this);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Add book", 100, 150);
        g.drawString("Delete book", 100, 200);
        g.drawString("Update book", 100, 250);
        g.drawString("View books", 100, 300);
        g.drawString("Retrieve a list of books with their authors.", 100, 350);
        g.drawString("Back", 50, 500);
    }

    public void createBook() {
        Object[] fields = {
                "ISBN", isbnField,
                "Title", titleField,
                "Publication year", publicationYearField,
                "Price", priceField
        };
        try {
            JOptionPane.showConfirmDialog(this, fields, "Add book", JOptionPane.OK_CANCEL_OPTION);
            model.createBook(isbnField.getText(), titleField.getText(), Integer.parseInt(publicationYearField.getText()), Double.parseDouble(priceField.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void updateBook() {

        Object[] fields = {
                "Title", titleField,
                "Publication year", publicationYearField,
                "Price", priceField
        };
        try {
            String isbn = JOptionPane.showInputDialog(this, "Enter ISBN of the book to update");

            if (model.isbnExists(isbn)){
                JOptionPane.showConfirmDialog(this, fields, "Update book", JOptionPane.OK_CANCEL_OPTION);
                model.updateBook(isbn, titleField.getText(), Integer.parseInt(publicationYearField.getText()), Double.parseDouble(priceField.getText()));
            } else {
                JOptionPane.showMessageDialog(this, "Such book does not exist.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void deleteBook() {
        try {
            String isbn = JOptionPane.showInputDialog(this, "Enter ISBN of the book to delete");
            if (model.isbnExists(isbn)){
                model.deleteBook(isbn);
            } else {
                JOptionPane.showMessageDialog(this, "Such book does not exist.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void viewBooks() {
        JComboBox<String> books = new JComboBox<>();
        for (Book book : model.showAllBooks()) {
            books.addItem(book.getTitle());
        }
        JOptionPane.showConfirmDialog(this, books, "Books", JOptionPane.DEFAULT_OPTION);
    }

    public void back() {
        setVisible(false);
        viewer.setVisible(true);
    }

}

