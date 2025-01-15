import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Piece {
    protected int x, y;
    protected String color;
    protected Image image;

    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Image getImage() {
        return image;
    }

    public String getColor() {
        return color;
    }

    public void move(int endX, int endY) {
        this.x = endX;
        this.y = endY;
    }

    public abstract boolean isValidMove(int endX, int endY, Piece[][] board);

    protected Image getImage(String path) {
        return new ImageIcon(getClass().getResource(path)).getImage();
    }
}