import java.awt.*;
import javax.swing.*;

public class View extends JFrame {

    MenuView menu;
    BoardView board;

    public View() {
        super("Kwazam Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout and size
        setLayout(new BorderLayout());
        setSize(600, 960);

        // Initialize components
        menu = new MenuView();
        board = new BoardView();

        board.initializeBoard();

        // Add components to the frame
        add(menu, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }
}
