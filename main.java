import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Kwazam Chess");
            Board gameBoard = new Board();
            JPanel boardPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    
                    // Set board size (480x300 for 8x5 grid with 60px cells)
                    setPreferredSize(new Dimension(8 * 60, 5 * 60));

                    // Draw grid lines
                    for (int i = 0; i <= 5; i++) {
                        g.drawLine(0, i * 60, 8 * 60, i * 60);  // Horizontal lines
                    }
                    for (int j = 0; j <= 8; j++) {
                        g.drawLine(j * 60, 0, j * 60, 5 * 60);  // Vertical lines
                    }
                    
                    // Draw pieces on the grid
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 8; j++) {
                            Ram piece = gameBoard.getPiece(i, j);
                            if (piece != null && piece.getImage() != null) {
                                g.drawImage(piece.getImage(), j * 60, i * 60, 60, 60, this);                            
                            } else if (piece != null) {
                                g.setColor(Color.BLUE);
                                g.fillRect(j * 60, i * 60, 60, 60);
                            }
                        }
                    }
                }
            };
            
            // Ensure panel size is respected
            boardPanel.setPreferredSize(new Dimension(8 * 60, 5 * 60));
            frame.add(boardPanel);
            frame.pack();  // Resize frame to fit panel
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            // Trigger repaint to ensure grid draws on launch
            boardPanel.repaint();
        });
    }
}
