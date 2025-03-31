package Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class MainMenu{

    protected JFrame frame;
    protected JPanel panel;

    public MainMenu() {


        frame = new JFrame();
        frame.setTitle("Super Hexagon");
        frame.setSize(1536, 864);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\super hexagon.png");
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 1536, 864);
        panel.setBackground(new Color(255,230,240));
        panel.setLayout(null);
        panel.add(startButton());
        panel.add(bestScore());
        panel.add(Score());
        panel.add(historyButton());
        panel.add(settingsButton());
        panel.add(exitButton());
        CentralHexagon centralHexagon = new CentralHexagon(250);
        centralHexagon.setBounds(0, 0, 1536, 864);
        panel.add(centralHexagon);
        DrawLine drawLine = new DrawLine(250);
        drawLine.setBounds(-1000, -1000, 15360, 8640);
        panel.add(drawLine);

        frame.add(panel);
        frame.setVisible(true);
    }

    public JButton startButton() {
        MakeButton startButton = new MakeButton("Start");
        startButton.setBounds(panel.getWidth()/2-175,600,350,90);
        startButton.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        startButton.setBorder(BorderFactory.createEtchedBorder());
        startButton.setBorder(BorderFactory.createRaisedBevelBorder());

        startButton.addActionListener(e -> new EnterDetails());

        return startButton;
    }
    public JLabel bestScore(){
        MakeLabel bestScore = new MakeLabel("22.6                 ");
        bestScore.setFont(new Font("Digital-7", Font.ITALIC, 50));
        bestScore.setBounds(panel.getWidth()-280,280,400,70);

        bestScore.setOpaque(true);
        return bestScore;
    }
    public JLabel Score(){
        MakeLabel Score = new MakeLabel("Best Score                                             ");
        Score.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        Score.setBounds(panel.getWidth()-450,280,450,50);

        Score.setOpaque(true);
        return Score;
    }
    public JButton historyButton() {
        MakeButton historyButton = new MakeButton("Game   History");
        historyButton.setBounds(-130,300,500,60);
        historyButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        historyButton.setBorder(BorderFactory.createEtchedBorder());
        historyButton.setBorder(BorderFactory.createRaisedBevelBorder());

        return historyButton;
    }
    public JButton settingsButton() {
        MakeButton settingsButton = new MakeButton("Settings");
        settingsButton.setBounds(-150,230,460,60);
        settingsButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        settingsButton.setBorder(BorderFactory.createEtchedBorder());
        settingsButton.setBorder(BorderFactory.createRaisedBevelBorder());

        settingsButton.addActionListener(e -> {
            try {
                new SettingPage();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                ex.printStackTrace();}
        });

        return settingsButton;
    }
    public JButton exitButton() {
        MakeButton exitButton = new MakeButton("Exit     ");
        exitButton.setBounds(1450,-5,120,60);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        exitButton.setBorder(BorderFactory.createEtchedBorder());
        exitButton.setBorder(BorderFactory.createRaisedBevelBorder());

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        return exitButton;
    }
}
