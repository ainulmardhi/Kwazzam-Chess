public class Ram extends Piece {

    public Ram(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public boolean step(int targetCol, int targetRow, Piece[][] board) {
        if (isWithinBoard(targetCol, targetRow, board)) {
            return targetCol == x + 1 && targetRow == y && board[targetCol][targetRow] == null;
        }
        return false;
    }
}
