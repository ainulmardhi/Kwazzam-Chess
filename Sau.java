public class Sau extends Piece {

    public Sau(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public boolean step(int targetCol, int targetRow, Piece[][] board) {
        if (!isWithinBoard(targetCol, targetRow, board)) {
            return false;
        }

        // Calculate the difference in columns and rows
        int colDiff = Math.abs(targetCol - x);
        int rowDiff = Math.abs(targetRow - y);

        // Sau can move one step in any direction (including diagonally)
        if ((colDiff == 1 && rowDiff == 0) || // Horizontal
            (colDiff == 0 && rowDiff == 1) || // Vertical
            (colDiff == 1 && rowDiff == 1)) {  // Diagonal
            // Check if the target square is empty or contains an opponent's piece
            Piece targetPiece = board[targetCol][targetRow];
            if (targetPiece == null || !targetPiece.getColor().equals(color)) {
                return true;
            }
        }

        return false;
    }
}
