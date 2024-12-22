import java.awt.*;

public class biz //extends piece
{
    public biz() {
        if (player == red) {
            image = getImage("/kwazam chess/icons/biz_red");
        } else {
            image = getImage("/kwazam chess/icons/biz_blue");
        }
        }
    }

    public boolean step(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol,targetRow)) {
           if (Math.abs(targetCol - preCol) * Math.abs(targetRow -preCol) == 2) {
               return true;
           }
        }
        return false;
    }
}
