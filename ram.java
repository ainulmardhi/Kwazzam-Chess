public class Ram extends Piece {
    private boolean movingForward = true;

    public Ram(int x, int y, String color) {
        super(x, y, color);
        if (color.equals("red")) {
            image = getImage("/kwazam chess/icons/ram_red.png");
        } else {
            image = getImage("/kwazam chess/icons/ram_blue.png");
        }
    }

    @Override
    public boolean isValidMove(int endX, int endY, Piece[][] board) {
        int direction = movingForward ? 1 : -1;
        if (endX == x + direction && endY == y && board[endX][endY] == null) {
            return true;
        }
        return false;
    }

    @Override
    public void move(int endX, int endY) {
        super.move(endX, endY);
        if (endX == 0 || endX == 7) {
            movingForward = !movingForward;
        }
    }
}