public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MenuView menuView = new MenuView();
            menuView.setVisible(true);
        });
    }
}