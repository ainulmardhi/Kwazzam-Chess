public class Sau extends Piece {
    public Sau(int x, int y, String color) {
        super(x, y, color);
        if (color.equals("red")) {
            image = getImage("/kwazam chess/icons/sau_red.png");
        } else {
            image = getImage("/kwazam chess/icons/sau_blue.png");
        }
    }

    @Override
    public boolean isValidMove(int endX, int endY, Piece[][] board) {
        int dx = Math.abs(endX - x);
        int dy = Math.abs(endY - y);
        return (dx <= 1 && dy <= 1);
    }
}