package com.kwazamchess.model;

public class Ram extends Piece {
    public Ram(int x, int y, String color) {
        super(x, y, color);
        image = getImage("/kwazam chess/icons/ram_" + color);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        if (newX < 0 || newX >= 8 || newY < 0 || newY >= 5) {
            return false;
        }
        if (color.equals("blue")) {
            return newX == x + 1 && newY == y && board[newX][newY] == null;
        } else {
            return newX == x - 1 && newY == y && board[newX][newY] == null;
        }
    }
}