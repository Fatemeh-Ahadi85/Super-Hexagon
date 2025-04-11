import javax.swing.*;
import java.awt.*;

public class PauseButton extends JDialog {
    public PauseButton() {
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\pause.jpg");

        this.setTitle("Pause");
        this.setBounds(600,400,300, 200);
        this.add(ResumeButton());
        this.add(text());
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setVisible(true);

    }
    public JButton ResumeButton() {
        JButton resumeButton = new JButton("Resume");
        resumeButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        resumeButton.setBounds(100,100,100,30);
        resumeButton.setBorder(BorderFactory.createEtchedBorder());
        resumeButton.setBorder(BorderFactory.createRaisedBevelBorder());

        resumeButton.addActionListener(e -> {
            GamePanel.gamePanel.RunTimer();
            this.dispose();
        });

        return resumeButton;
    }
    public JLabel text(){
        JLabel textLabel = new JLabel("You can rest a little!");
        textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textLabel.setBounds(65,10,300,100);

        return textLabel;
    }
}
