
import javax.swing.*;
import java.awt.*;

public class GameTimer extends MakeLabel {
    private long StartTime;
    public Timer timer;
    public static String text;

    public GameTimer() {
        super("0:000");
        StartTime = System.currentTimeMillis();

        this.setFont(new Font("Digital-7", Font.ITALIC, 30));
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        setOpaque(true);

        timer = new Timer(10, e -> {
            ShowTime();
        });
        timer.start();
    }
    public void ShowTime() {
        long time = System.currentTimeMillis() - StartTime;
        long seconds = time / 1000;
        long milliSeconds = time % 1000;
        text = seconds + ":" + String.format("%03d", milliSeconds);

        this.setText(text);
    }
}
