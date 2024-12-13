import entities.Book;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class BooksPanel extends JPanel {
    private Viewer viewer;
    private Model model;
    private Font font;
    private Image background;
    private JOptionPane book;
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
        book = new JOptionPane();


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
            String showInputDialog = JOptionPane.showInputDialog(this, "Enter ISBN of the book to update");
            JOptionPane.showConfirmDialog(this, fields, "Update book", JOptionPane.OK_CANCEL_OPTION);

            model.updateBook(showInputDialog, titleField.getText(), Integer.parseInt(publicationYearField.getText()), Double.parseDouble(priceField.getText()));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void deleteBook() {
        try {
            String showInputDialog = JOptionPane.showInputDialog(this, "Enter ISBN of the book to delete");
            model.deleteBook(showInputDialog);
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

