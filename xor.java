import java.awt.*;

public class xor extends Piece{
    public xor(int player, int col, int row){
        super(player, col, row);
        if (player == red) {
            image = getImage("/kwazam chess/icons/xor_red");
        } else {
            image = getImage("/kwazam chess/icons/xor_blue");
        }
    }

    public boolean canMove(int targetCol, int targetRow){
        if(isWithinBoard(targetCol,targetRow) && 
        isSameSquare(targetCol, targetRow) == false){
            if(Maths.abs(targetCol - preCol) == Maths.abs(targetRow - preRow)){
                if(isValidSquare(targetCol, targetRow) && 
                pieceIsOnDiagonalLine(targetCol, targetRow) == false){
                    return true;
                }
            }
        }
        return false;
    }
}