public class Tor extends Piece {

    public Tor(int x, int y, String color){
        super(x, y, color);
    }

    @Override
    public boolean step(int targetCol, int targetRow, Piece[][] board) {
        if (!isWithinBoard(targetCol, targetRow, board)) {
            return false;
        }
        // if(isWithinBoard(targetCol,targetRow) && 
        // isSameSquare(targetCol, targetRow) == false){
        //     if(targetCol == preCol || targetRow == preRow){
        //         if(isValidSquare(targetCol, targetRow) && 
        //         pieceIsOnStraightLine(targetCol, targetRow) == false){
        //             return true;
        //         }
        //     }
        // }
        return false;
    }
}