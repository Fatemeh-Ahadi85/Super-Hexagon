import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOver extends GamePanel{

    private String Time;

    public GameOver() {
        super();
        GameTimer timer = new GameTimer();
        this.Time = timer.getTime();
    }
    public void fail() throws IOException {
        stopTimers();
        User user = new User();
        user.setTime(this.Time);
        user.saveToJson();

        for (Component com : panel.getComponents()) {
            panel.remove(com);
        }
        panel.revalidate();
        panel.repaint();

        JLayeredPane layeredPane = (JLayeredPane) MainMenu.mainMenu.frame.getContentPane();
        layeredPane.removeAll();

        layeredPane.add(MainMenu.mainMenu.panel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.revalidate();
        layeredPane.repaint();


        JOptionPane.showMessageDialog(null, "Game Over!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);

    }
    public void stopTimers() {
        GameTimer gameTimer = new GameTimer();
        if(gameTimer.timer != null) gameTimer.timer.stop();
        if (timer != null) timer.stop();
        if (timer1 != null) timer1.stop();
        if (timer2 != null) timer2.stop();
    }

}
