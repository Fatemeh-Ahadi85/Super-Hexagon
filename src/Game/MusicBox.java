package Game;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MusicBox extends SettingBoxes{
    private Clip clip;
    private static MusicBox instance;

    public MusicBox() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File musicFile = new File("C:\\Users\\ASUS\\Downloads\\Super Hexagon.wav");
        AudioInputStream stream = AudioSystem.getAudioInputStream(musicFile);
        clip = AudioSystem.getClip();
        clip.open(stream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public static MusicBox getInstance() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(instance == null) {
            instance = new MusicBox();
        }
        return instance;
    }

    @Override
    public JCheckBox box(){

        checkBox = new JCheckBox("Enable Theme Music",true);
        checkBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        checkBox.setForeground(Color.black);
        checkBox.setFocusPainted(false);


        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()&&!clip.isRunning()) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else if(!checkBox.isSelected()&&clip.isRunning()) {
                clip.stop();
            }
        });
        return checkBox;
    }
}
