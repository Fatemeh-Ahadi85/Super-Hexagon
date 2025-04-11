package Game;

import javax.swing.*;
import java.awt.*;

public class GameTimer extends MakeLabel {
    private long StartTime;

    public GameTimer() {
        super("0:000"); // متن اولیه تایمر
        StartTime = System.currentTimeMillis();

        // تنظیمات فونت، پس‌زمینه و رنگ‌ها
        this.setFont(new Font("Digital-7", Font.ITALIC, 15));
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        setOpaque(true);

        // تایمر برای به‌روزرسانی هر 10 میلی‌ثانیه
        Timer timer = new Timer(10, e -> {
            ShowTime();
        });
        timer.start();
    }

    // متد برای نمایش تایمر
    public void ShowTime() {
        long time = System.currentTimeMillis() - StartTime;
        long seconds = time / 1000;
        long milliSeconds = time % 1000;

        // به‌روزرسانی متن
        this.setText(seconds + ":" + String.format("%03d", milliSeconds));
    }
}
