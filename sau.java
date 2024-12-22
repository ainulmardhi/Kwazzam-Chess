import java.awt.*;

public class sau //extends piece
{
    public sau() {
        if (player == red) {
            image = getImage("/kwazam chess/icons/sau_red");
        } else {
            image = getImage("/kwazam chess/icons/sau_blue");
        }
        }
    }

    public boolean step(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol,targetRow)) {
           if (Math.abs(targetCol - preCol) * Math.abs(targetRow -preCol) == 1) || if (Math.abs(targetCol - preCol) + Math.abs(targetRow -preCol) == 1) {
               if (isValidSquare(targetCol, targetRow)) {
               return true;
                }
            }
        }
        return false;
    }
}