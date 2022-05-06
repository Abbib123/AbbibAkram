package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel {
    public JPanel mainPanel;
    private JButton volumeUpButton;
    private JButton volumeDownButton;
    private JButton backButton;

    private Game game;

    public SettingsPanel(Game game) {
        this.game = game;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMain();
                //Transition back to main menu
            }
        });
    }
}
