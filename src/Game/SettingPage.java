package Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SettingPage extends MainMenu{

    public SettingPage() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\setting.png");
        JDialog dialog = new JDialog();
        dialog.setTitle("Settings");
        dialog.setSize(250,150);
        dialog.setLocationRelativeTo(frame);
        dialog.setIconImage(icon.getImage());
        dialog.setLayout(new FlowLayout());

        JPanel settingsPanel = new JPanel();

        SettingBoxes music = MusicBox.getInstance();
        settingsPanel.add(music.box());

        dialog.add(settingsPanel);
        dialog.setVisible(true);

    }

}
