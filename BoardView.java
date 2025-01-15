import java.awt.*;
import javax.swing.*;

public class BoardView extends JPanel {
    
    JButton[][] boardButtons;
    //Piece[][] pieces;

    public BoardView() {
        setLayout(new GridLayout(8, 5)); //8 rows, 5 columns

        boardButtons = new JButton[8][5];
        //pieces = new Piece[8][5];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                boardButtons[i][j] = new JButton();
                boardButtons[i][j].setPreferredSize(new Dimension(60, 60));

                // Alternate colors for the board
                if ((i + j) % 2 == 0) {
                    boardButtons[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    boardButtons[i][j].setBackground(Color.DARK_GRAY);
                }

                add(boardButtons[i][j]);
            }
        }
    }

    public void loadPieceIcons(int x, int y, String pieceType, String color) {
        String filePath = "icons/" + pieceType.toLowerCase() + "_" + color.toLowerCase() + ".png";
        try {
            ImageIcon icon = new ImageIcon(filePath);
            // Resize icon to fit button
            Image scaledIcon = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            boardButtons[x][y].setIcon(new ImageIcon(scaledIcon));
        } catch (Exception e) {
            System.err.println("Error loading icon: " + filePath);
        }
    }

    public void initializeBoard() {
        // Example setup: Place blue pieces on row 6 and red pieces on row 2
        for (int i = 0; i < 5; i++) {
            loadPieceIcons(6, i, "ram", "blue");
            loadPieceIcons(1, i, "ram", "red");
        }

        // Additional example pieces
        loadPieceIcons(7, 1, "biz", "blue");
        loadPieceIcons(0, 1, "biz", "red");
        loadPieceIcons(7, 3, "biz", "blue");
        loadPieceIcons(0, 3, "biz", "red");
        loadPieceIcons(7, 4, "tor", "blue");
        loadPieceIcons(0, 0, "tor", "red");
        loadPieceIcons(7, 0, "xor", "blue");
        loadPieceIcons(0, 4, "xor", "red");
        loadPieceIcons(7, 2, "sau", "blue");
        loadPieceIcons(0, 2, "sau", "red");
    }

    // public void updateBoard( model) {
    //     for (int i = 0; i < 5; i++) {
    //         for (int j = 0; j < 8; j++) {
    //             Piece piece = model.getPieceAt(i, j);

    //             if (piece != null) {
    //                 // Set the icon for the piece
    //                 String pieceType = piece.getType();
    //                 String color = piece.getColor();
    //                 String filePath = "/Users/aisyah/Desktop/kwazam/icons/" 
    //                                 + pieceType.toLowerCase() + "_" 
    //                                 + color.toLowerCase() + ".png";

    //                 try {
    //                     ImageIcon icon = new ImageIcon(filePath);
    //                     // Resize icon to fit button
    //                     Image scaledIcon = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    //                     boardButtons[i][j].setIcon(new ImageIcon(scaledIcon));
    //                 } catch (Exception e) {
    //                     System.err.println("Error loading icon: " + filePath);
    //                 }
    //             } else {
    //                 // Clear the icon if the cell is empty
    //                 boardButtons[i][j].setIcon(null);
    //             }
    //         }
    //     }
    // }

    //public void flipScreen() {} on each turn
}
