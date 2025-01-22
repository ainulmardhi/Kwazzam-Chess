import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller {
    private BoardView board;
    private int selectedX = -1;
    private int selectedY = -1;
    private String currentPlayer = "blue"; // Blue starts first
    private boolean gameOver = false;

    public Controller(BoardView board, MenuView menu) {
        this.board = board;

        // Attach mouse listeners to the board buttons
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                board.boardButtons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleMouseClick(e);
                    }
                });
            }
        }

        // Add menu listeners
        menu.addNewGameListener(e -> handleNewGameAction());
        menu.addSaveGameListener(e -> handleSaveGameAction());
        menu.addLoadGameListener(e -> handleLoadGameAction());
    }

    private void handleMouseClick(MouseEvent e) {
        if (gameOver) {
            return; // Do nothing if the game is over
        }

        JButton button = (JButton) e.getSource();
        int col = -1, row = -1;

        // Find the button's position in the grid
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                if (board.boardButtons[i][j] == button) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (selectedX == -1 && selectedY == -1) {
            // Select a piece if one exists at the clicked position
            Piece piece = board.getPiece(row, col);
            if (piece != null && piece.getColor().equals(currentPlayer)) {
                selectedX = row;
                selectedY = col;
                System.out.println("Selected piece at (" + selectedX + ", " + selectedY + ")");
            }
        } else {
            // Attempt to move the selected piece
            if (movePiece(selectedX, selectedY, row, col)) {
                System.out.println(
                        "Moved piece from (" + selectedX + ", " + selectedY + ") to (" + row + ", " + col + ")");
                selectedX = -1;
                selectedY = -1;
                // Switch turns
                currentPlayer = currentPlayer.equals("blue") ? "red" : "blue";
            } else {
                System.out.println(
                        "Invalid move from (" + selectedX + ", " + selectedY + ") to (" + row + ", " + col + ")");
                selectedX = -1;
                selectedY = -1;
            }
        }
    }

    private void handleNewGameAction() {
        board.initializeBoard();
        board.repaint();
        currentPlayer = "blue"; 
        JOptionPane.showMessageDialog(board, "Game Started !" + currentPlayer + " starts first.");
        gameOver = false;
    }

    private void handleSaveGameAction() {
        System.out.println("Save game logic not implemented yet.");
    }

    private void handleLoadGameAction() {
        System.out.println("Load game logic not implemented yet.");
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board.getPiece(startX, startY);
        Piece targetPiece = board.getPiece(endX, endY);
        if (piece != null && piece.isValidMove(endX, endY, board.getBoard())) {
            piece.move(endX, endY);
            board.setPiece(endX, endY, piece);
            board.setPiece(startX, startY, null);

            board.boardButtons[endX][endY].setIcon(board.boardButtons[startX][startY].getIcon());
            board.boardButtons[startX][startY].setIcon(null);

            if (targetPiece instanceof Sau && !targetPiece.getColor().equals(currentPlayer)) {
                String winColor = targetPiece.getColor().equals("red") ? "blue" : "red";

                System.out.println("Game Over! " + targetPiece.getColor() + " Sau captured.");
                JOptionPane.showMessageDialog(board, "Game Over! "+winColor+ " player Win ! " + targetPiece.getColor() + " player's Sau captured."); 
                gameOver = true;
            }

            return true;
        }
        return false;
    }

}