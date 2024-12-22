package com.kwazamchess.model;

import java.awt.*;

public abstract class Piece {
    protected int x, y;
    protected String color;
    protected Image image;

    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    protected Image getImage(String path) {
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource(path));
    }

    public abstract boolean isValidMove(int newX, int newY, Piece[][] board);

    public int getX() { return x; }
    public int getY() { return y; }
    public String getColor() { return color; }

    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }
}