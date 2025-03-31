package Game;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;

abstract class SettingBoxes {

    JCheckBox checkBox;
    public abstract JCheckBox box() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
    public SettingBoxes() {
        checkBox = new JCheckBox();
    }
}
