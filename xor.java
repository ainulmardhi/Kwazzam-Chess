public class Xor extends Piece {
    private int turns = 0;

    public Xor(int x, int y, String color) {
        super(x, y, color);
        if (color.equals("red")) {
            image = getImage("/kwazam chess/icons/xor_red.png");
        } else {
            image = getImage("/kwazam chess/icons/xor_blue.png");
        }
    }

    @Override
    public boolean isValidMove(int endX, int endY, Piece[][] board) {
        if (Math.abs(endX - x) == Math.abs(endY - y)) {
            int dx = Integer.signum(endX - x);
            int dy = Integer.signum(endY - y);
            for (int i = 1; i < Math.abs(endX - x); i++) {
                if (board[x + i * dx][y + i * dy] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void move(int endX, int endY) {
        super.move(endX, endY);
        turns++;
        if (turns >= 2) {
            transform();
        }
    }

    private void transform() {
        // Transform into Tor
        board[x][y] = new Tor(x, y, color);
    }
}