import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
    private Piece[][] board;
    private int selectedX = -1;
    private int selectedY = -1;

    public Board() {
        board = new Piece[8][5]; // 8x5 grid
        initializeBoard();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        });
    }

    private void initializeBoard() {
        // Initialize the board with nulls
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 5; col++) {
                board[row][col] = null;
            }
        }

        // Place Blue Rams on row 1
        for (int col = 0; col < 5; col++) {
            board[1][col] = new Ram(1, col, "red");
        }

        // Place Red Rams on row 6
        for (int col = 0; col < 5; col++) {
            board[6][col] = new Ram(6, col, "blue");
        }

        // Place Blue pieces
        board[0][0] = new Tor(0, 0, "red");
        board[0][1] = new Biz(0, 1, "red");
        board[0][2] = new Sau(0, 2, "red");
        board[0][3] = new Biz(0, 3, "red");
        board[0][4] = new Xor(0, 4, "red");

        // Place Red pieces
        board[7][0] = new Xor(7, 0, "blue");
        board[7][1] = new Biz(7, 1, "blue");
        board[7][2] = new Sau(7, 2, "blue");
        board[7][3] = new Biz(7, 3, "blue");
        board[7][4] = new Tor(7, 4, "blue");
    }

    private void handleMouseClick(MouseEvent e) {
        int col = e.getX() / 60;
        int row = e.getY() / 60;

        if (selectedX == -1 && selectedY == -1) {
            // Select piece
            if (board[row][col] != null) {
                selectedX = row;
                selectedY = col;
            }
        } else {
            // Move piece
            if (movePiece(selectedX, selectedY, row, col)) {
                selectedX = -1;
                selectedY = -1;
                repaint();
            } else {
                // Invalid move, deselect piece
                selectedX = -1;
                selectedY = -1;
            }
        }
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board[startX][startY];
        if (piece != null && piece.isValidMove(endX, endY, board)) {
            piece.move(endX, endY);
            board[endX][endY] = piece;
            board[startX][startY] = null;

            // Check if Sau is captured
            if (board[endX][endY] instanceof Sau) {
                System.out.println("Game Over! " + board[endX][endY].getColor() + " Sau captured.");
                // End game logic here
            }

            return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= 8; i++) { // Adjusted for 8 rows
            g.drawLine(0, i * 60, 5 * 60, i * 60); // Horizontal lines
        }
        for (int j = 0; j <= 5; j++) { // Adjusted for 5 columns
            g.drawLine(j * 60, 0, j * 60, 8 * 60); // Vertical lines
        }

        // Draw pieces on the grid
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                Piece piece = board[i][j];
                if (piece != null && piece.getImage() != null) {
                    g.drawImage(piece.getImage(), j * 60, i * 60, 60, 60, this);
                }
            }
        }
    }
}