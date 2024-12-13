import javax.swing.JPanel;
import java.awt.Color;

public class BooksPanel extends JPanel {
    private Viewer viewer;

    public BooksPanel(Viewer viewer) {
        this.viewer = viewer;
        setBackground(Color.RED);
    }
}
