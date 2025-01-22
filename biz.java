public class Biz extends Piece {

    public Biz(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public boolean isValidMove(int targetCol, int targetRow, Piece[][] board) {
        return step(targetCol, targetRow, board);
    }

    @Override
    public boolean step(int targetCol, int targetRow, Piece[][] board) {
        if (isWithinBoard(targetCol, targetRow, board)) {
            int dx = Math.abs(targetCol - x);
            int dy = Math.abs(targetRow - y);
            return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
        }
        return false;
    }
}