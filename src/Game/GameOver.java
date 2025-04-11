package Game;

import javax.swing.*;
import java.awt.*;

public class GameOver extends GamePanel{
    public GameOver() {
        super();
    }
    public void fail() {
        stopTimers();

        for (Component c : getComponents()) {
            if (c instanceof Obstacles) {
                panel.remove(c);
            }
        }
        panel.revalidate();
        panel.repaint();

        SwingUtilities.invokeLater(() -> {
            frame.getContentPane().remove(this);
            frame.revalidate();
            frame.repaint();
            frame.dispose();
        });

        JOptionPane.showMessageDialog(null, "Game Over!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);

        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.frame.setVisible(true);
        });
    }
    public void stopTimers() {
        if (timer != null) timer.stop();
        if (timer1 != null) timer1.stop();
        if (timer2 != null) timer2.stop();
    }

}
