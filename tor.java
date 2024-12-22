import java.awt.*;

public class tor{ //extends Piece
    public tor(int player, int col, int row){
        super(player, col, row);
        if (player == red) {
            image = getImage("/kwazam chess/icons/tor_red");
        } else {
            image = getImage("/kwazam chess/icons/tor_blue");
        }
    }

    public boolean canMove(int targetCol, int targetRow){
        if(isWithinBoard(targetCol,targetRow) && 
        isSameSquare(targetCol, targetRow) == false){
            if(targetCol == preCol || targetRow == preRow){
                if(isValidSquare(targetCol, targetRow) && 
                pieceIsOnStraightLine(targetCol, targetRow) == false){
                    return true;
                }
            }
        }
        return false;
    }
}