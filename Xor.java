public class Xor extends Piece{
    
    public Xor(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public boolean step(int targetCol, int targetRow, Piece[][] board) {
        if (!isWithinBoard(targetCol, targetRow, board)) {
            return false;
        
            // if(Maths.abs(targetCol - preCol) == Maths.abs(targetRow - preRow)){
            //     if(isValidSquare(targetCol, targetRow) && 
            //     pieceIsOnDiagonalLine(targetCol, targetRow) == false){
            //         return true;
            //     }
            // }
        }
        return false;
    }
}