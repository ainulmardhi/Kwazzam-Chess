import javax.swing.*;

public class View {
    private BoardView boardView;
    private MenuView menuView;

    public View() {
        boardView = new BoardView();
        menuView = new MenuView();
    }

    public BoardView getBoard() {
        return boardView;
    }

    public MenuView getMenu() {
        return menuView;
    }
}
