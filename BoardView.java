import java.awt.*;
import javax.swing.*;

public class BoardView extends JPanel {

    JButton[][] boardButtons;
    private Piece[][] board;

    public BoardView() {
        setLayout(new GridLayout(8, 5)); // 8 rows, 5 columns

        boardButtons = new JButton[8][5];
        board = new Piece[8][5];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                boardButtons[i][j] = new JButton();
                boardButtons[i][j].setPreferredSize(new Dimension(60, 60));

                // Alternate colors for the board
                if ((i + j) % 2 == 0) {
                    boardButtons[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    boardButtons[i][j].setBackground(Color.DARK_GRAY);
                }

                add(boardButtons[i][j]);
            }
        }
    }

    public void loadPieceIcons(int x, int y, String pieceType, String color) {
        String filePath = "icons/" + pieceType.toLowerCase() + "_" + color.toLowerCase() + ".png";
        try {
            ImageIcon icon = new ImageIcon(filePath);
            // Resize icon to fit button
            Image scaledIcon = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            boardButtons[x][y].setIcon(new ImageIcon(scaledIcon));
        } catch (Exception e) {
            System.err.println("Error loading icon: " + filePath);
        }
    }

    public void initializeBoard() {
        // Initialize the board with nulls
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 5; col++) {
                board[row][col] = null;
                boardButtons[row][col].setIcon(null); // Clear the icons
            }
        }

        // Example setup: Place blue pieces on row 6 and red pieces on row 2
        for (int i = 0; i < 5; i++) {
            board[6][i] = new Ram(6, i, "blue");
            loadPieceIcons(6, i, "ram", "blue");
            board[1][i] = new Ram(1, i, "red");
            loadPieceIcons(1, i, "ram", "red");
        }

        // Additional example pieces
        board[7][1] = new Biz(7, 1, "blue");
        loadPieceIcons(7, 1, "biz", "blue");
        board[0][1] = new Biz(0, 1, "red");
        loadPieceIcons(0, 1, "biz", "red");
        board[7][3] = new Biz(7, 3, "blue");
        loadPieceIcons(7, 3, "biz", "blue");
        board[0][3] = new Biz(0, 3, "red");
        loadPieceIcons(0, 3, "biz", "red");
        board[7][4] = new Tor(7, 4, "blue");
        loadPieceIcons(7, 4, "tor", "blue");
        board[0][0] = new Tor(0, 0, "red");
        loadPieceIcons(0, 0, "tor", "red");
        board[7][0] = new Xor(7, 0, "blue");
        loadPieceIcons(7, 0, "xor", "blue");
        board[0][4] = new Xor(0, 4, "red");
        loadPieceIcons(0, 4, "xor", "red");
        board[7][2] = new Sau(7, 2, "blue");
        loadPieceIcons(7, 2, "sau", "blue");
        board[0][2] = new Sau(0, 2, "red");
        loadPieceIcons(0, 2, "sau", "red");
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void setPiece(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    public Piece[][] getBoard() {
        return board;
    }
}