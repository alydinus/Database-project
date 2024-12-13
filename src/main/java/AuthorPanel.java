import entities.Author;
import entities.Book;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class AuthorPanel extends JPanel {
    private Viewer viewer;
    private Model model;

    private JTextField nameField;
    private JTextField surname;

    private Font font;
    private Image background;


    public AuthorPanel(Viewer viewer, Model model) {
        this.viewer = viewer;
        this.model = model;
        font = viewer.getFont();
        background = viewer.getBackgroundImage();
        addMouseListener(viewer.getController());

        nameField = new JTextField();
        surname = new JTextField();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 800, 600, this);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Add author", 100, 150);
        g.drawString("Delete author", 100, 200);
        g.drawString("Update author", 100, 250);
        g.drawString("View authors", 100, 300);
        g.drawString("Back", 50, 500);
    }

    public void createAuthor() {
        Object[] fields = {
                "Name", nameField,
                "Surname", surname
        };
        try {
            JOptionPane.showConfirmDialog(this, fields, "Add author", JOptionPane.OK_CANCEL_OPTION);
            model.createAuthor(nameField.getText(), surname.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void updateAuthor() {
        Object[] fields = {
                "Name", nameField,
                "Surname", surname
        };
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Please enter author id to update:"));
            if (model.authorExists(id)){
                JOptionPane.showConfirmDialog(this, fields, "Update author", JOptionPane.OK_CANCEL_OPTION);
                model.updateAuthor(id, nameField.getText(), surname.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Author with id " + id + " does not exist");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void deleteAuthor() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Please enter author id to delete:"));
            if (model.authorExists(id)){
                model.deleteAuthor(id);
            } else {
                JOptionPane.showMessageDialog(this, "Author with id " + id + " does not exist");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public void viewAuthors() {
        JComboBox<String> authors = new JComboBox<>();
        for (Author author : model.showAllAuthors()) {
            authors.addItem(author.getName() + " " + author.getSurname());
        }
        JOptionPane.showConfirmDialog(this, authors, "Authors", JOptionPane.DEFAULT_OPTION);
    }

    public void back() {
        setVisible(false);
        viewer.setVisible(true);
    }


}
