import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Ram[][] board;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= 5; i++) {
            g.drawLine(0, i * 60, 8 * 60, i * 60);  // Horizontal lines
        }
        for (int j = 0; j <= 8; j++) {
            g.drawLine(j * 60, 0, j * 60, 5 * 60);  // Vertical lines
        }
    }

    public Board() {
        board = new Ram[5][8];  // 5x8 grid
        initializeBoard();
    }

    private void initializeBoard() {
        // Place Rams
        board[0][0] = new Ram(0, 0, "blue");
        board[4][0] = new Ram(4, 0, "red");
        // // Place other pieces
        // board[0][1] = new xor(0, 1, 1); // 1 for blue
        // board[0][2] = new tor(1, 0, 2);
        // board[0][3] = new sau();
        // board[0][4] = new biz();

        // board[4][1] = new xor(1, 4, 1); // 1 for red
        // board[4][2] = new tor(0, 4, 2);
        // board[4][3] = new sau();
        // board[4][4] = new biz();
    }

    public Ram getPiece(int x, int y) {
        return board[x][y];
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Ram piece = board[startX][startY];
        if (piece != null && piece.isValidMove(endX, endY, board)) {
            piece.move(endX, endY);
            board[endX][endY] = piece;
            board[startX][startY] = null;
            return true;
        }
        return false;
    }
}
