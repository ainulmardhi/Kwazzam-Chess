import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuView extends JFrame {
    private JButton newButton;
    private JButton saveButton;
    private JButton loadButton;
    private BoardView boardView;
    private Controller controller;

    public MenuView() {
        super("Kwazam Chess - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        setSize(700, 600);

        newButton = new JButton("New Game");
        saveButton = new JButton("Save Game");
        loadButton = new JButton("Load Game");

        add(newButton);
        add(saveButton);
        add(loadButton);

        // Attach actions to the buttons
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadGame();
            }
        });
    }

    private void startNewGame() {
        // Create a new BoardView
        boardView = new BoardView();

        // Initialize Controller
        controller = new Controller(boardView, this);

        // Replace the current content with BoardView
        this.getContentPane().removeAll();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(boardView, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();

        // Update frame title
        this.setTitle("Kwazam Chess - Game Board");

        // Initialize the board for a new game
        boardView.initializeBoard();
    }

    private void saveGame() {
        // Placeholder for save game functionality
        JOptionPane.showMessageDialog(this, "Save Game feature is not implemented yet.");
    }

    private void loadGame() {
        // Placeholder for load game functionality
        JOptionPane.showMessageDialog(this, "Load Game feature is not implemented yet.");
    }

    // Expose add*Listener methods for Controller
    public void addNewGameListener(ActionListener listener) {
        newButton.addActionListener(listener);
    }

    public void addSaveGameListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addLoadGameListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }
}
