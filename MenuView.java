import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuView extends JPanel{
    JButton newButton;
    JButton saveButton;
    JButton loadButton;

    public MenuView() {
        setLayout(new GridLayout(1,3));

        newButton = new JButton("New Game");
        saveButton = new JButton("Save Game");
        loadButton = new JButton("Load Game");

        add(newButton);
        add(saveButton);
        add(loadButton);
    }

    public void addButtonListener(ActionListener listener) {
         newButton.addActionListener(listener);
         loadButton.addActionListener(listener);
         saveButton.addActionListener(listener);
    }
}
