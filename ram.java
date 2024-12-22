import javax.swing.*;
import java.awt.*;

public class Ram {
    private int x, y;
    private String color;
    private Image image;

    public Image getImage() {
        return image;
    }
    

    public Ram(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
        if (color.equals("red")) {
            image = getImage("/kwazam chess/icons/ram_red.png");
        } else {
            image = getImage("/kwazam chess/icons/ram_blue.png");
        }
    }

    public boolean isValidMove(int newX, int newY, Ram[][] board) {
        if (isWithinBoard(newX, newY)) {
            if (color.equals("blue")) {
                return newX == x + 1 && newY == y && board[newX][newY] == null;
            } else {
                return newX == x - 1 && newY == y && board[newX][newY] == null;
            }
        }
        return false;
    }

    private boolean isWithinBoard(int newX, int newY) {
        return newX >= 0 && newX < 8 && newY >= 0 && newY < 5;
    }

    private Image getImage(String path) {
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource(path));
    }

    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }
}