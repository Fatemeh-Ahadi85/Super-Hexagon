package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu implements Runnable{

    private JFrame frame;
    private JPanel panel;

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

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void run() {

    }
    public JButton startButton() {
        MakeButton startButton = new MakeButton("Start");
        startButton.setBounds(panel.getWidth()/2-175,600,350,90);
        startButton.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        startButton.setBorder(BorderFactory.createEtchedBorder());
        startButton.setBorder(BorderFactory.createRaisedBevelBorder());

        startButton.addActionListener(e -> new GamePanel());

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

        return settingsButton;
    }
    public JButton exitButton() {
        MakeButton exitButton = new MakeButton("Exit     ");
        exitButton.setBounds(1450,-5,120,60);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        exitButton.setBorder(BorderFactory.createEtchedBorder());
        exitButton.setBorder(BorderFactory.createRaisedBevelBorder());

        return exitButton;
    }
}
