public class Sau extends Piece {

    public Sau(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public boolean isValidMove(int targetCol, int targetRow, Piece[][] board) {
        return step(targetCol, targetRow, board);
    }

    @Override
    public boolean step(int targetCol, int targetRow, Piece[][] board) {
        if (!isWithinBoard(targetCol, targetRow, board)) {
            return false;
        }

        int colDiff = Math.abs(targetCol - x);
        int rowDiff = Math.abs(targetRow - y);

        if ((colDiff == 1 && rowDiff == 0) || // Horizontal
                (colDiff == 0 && rowDiff == 1) || // Vertical
                (colDiff == 1 && rowDiff == 1)) { // Diagonal
            Piece targetPiece = board[targetCol][targetRow];
            if (targetPiece == null || !targetPiece.getColor().equals(color)) {
                return true;
            }
        }

        return false;
    }
}