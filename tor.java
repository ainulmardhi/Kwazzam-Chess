public class Tor extends Piece {
    private int turns = 0;

    public Tor(int x, int y, String color) {
        super(x, y, color);
        if (color.equals("red")) {
            image = getImage("/kwazam chess/icons/tor_red.png");
        } else {
            image = getImage("/kwazam chess/icons/tor_blue.png");
        }
    }

    @Override
    public boolean isValidMove(int endX, int endY, Piece[][] board) {
        if (x == endX || y == endY) {
            int dx = Integer.signum(endX - x);
            int dy = Integer.signum(endY - y);
            for (int i = 1; i < Math.max(Math.abs(endX - x), Math.abs(endY - y)); i++) {
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
        // Transform into Xor
        board[x][y] = new Xor(x, y, color);
    }
}