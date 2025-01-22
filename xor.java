public class Xor extends Piece {

    private int turns = 0;

    public Xor(int x, int y, String color) {
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
        if (Math.abs(targetCol - x) == Math.abs(targetRow - y)) {
            int dx = targetCol - x;
            int dy = targetRow - y;
            int steps = Math.abs(dx);
            for (int i = 1; i < steps; i++) {
                int stepX = x + i * Integer.signum(dx);
                int stepY = y + i * Integer.signum(dy);
                if (board[stepX][stepY] != null) {
                    return false;
                }
            }
            turns++;
            if (turns >= 2) {
                board[x][y] = new Tor(x, y, color);
            }
            return true;
        }
        return false;
    }
}