public class Ram extends Piece {

    public Ram(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public boolean isValidMove(int targetCol, int targetRow, Piece[][] board) {
        return step(targetCol, targetRow, board);
    }

    @Override
    public boolean step(int targetCol, int targetRow, Piece[][] board) {
        if (isWithinBoard(targetCol, targetRow, board)) {
            int direction = color.equals("red") ? 1 : -1;
            if (targetCol == x + direction && targetRow == y && board[targetCol][targetRow] == null) {
                return true;
            }
            if (targetCol == x + direction && (targetRow == y - 1 || targetRow == y + 1)) {
                Piece targetPiece = board[targetCol][targetRow];
                if (targetPiece != null && !targetPiece.getColor().equals(this.color)) {
                    return true;
                }
            }
        }
        return false;
    }
}