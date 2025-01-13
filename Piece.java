public abstract class Piece {
    protected int x, y;
    protected String color;

    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    protected boolean isWithinBoard(int newX, int newY, Piece[][] board) {
        return newX >= 0 && newX < 8 && newY >= 0 && newY < 5; // Assuming 5x8 board
    }

    public abstract boolean step(int newX, int newY, Piece[][] board);
}
