public class Biz extends Piece {
    public Biz(int x, int y, String color) {
        super(x, y, color);
        if (color.equals("red")) {
            image = getImage("/kwazam chess/icons/biz_red.png");
        } else {
            image = getImage("/kwazam chess/icons/biz_blue.png");
        }
    }

    @Override
    public boolean isValidMove(int endX, int endY, Piece[][] board) {
        int dx = Math.abs(endX - x);
        int dy = Math.abs(endY - y);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}