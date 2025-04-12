import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    protected JFrame frame;
    protected JPanel panel;
    protected double theta = 0;
    protected Timer timer;
    public static GamePanel gamePanel;
    public GameTimer gameTimer;
    public int i=1;
    public int m=0;
    private boolean isGameOver = false;


    public GamePanel() {
        gamePanel = this;
        if(!isGameOver) {
            timer = new Timer(25, e -> {
                if (!isGameOver) {
                    //  return;
                    m += 30;
                    if (m >= 1500) {
                        changeColor();
                        Obstacles obstacles = new Obstacles(75);
                        JComponent newObstacles = obstacles.generateObstacles();
                        newObstacles.setBounds(-1000, -1000, 3000, 3000);
                        panel.add(newObstacles);
                        panel.setComponentZOrder(newObstacles, 1);

                        if (newObstacles instanceof Obstacles) {
                            ((Obstacles) newObstacles).timer.start();
                        }
                        m = 0;
                    }
                    for(Timer time : Obstacles.deleteTimer){
                        time.stop();
                    }
                    SwingUtilities.invokeLater(() -> {
                        for (Component com : panel.getComponents()) {
                            if (com instanceof Obstacles) {
                                if (((Obstacles) com).radius <= 7.5) {
                                    panel.remove(com);
                                    panel.revalidate();
                                }
                            }
                        }
                    });
                    theta += 0.55;
                    panel.repaint();
                }
            });
        }
        timer.start();
        frame = MainMenu.mainMenu.frame;

        JLayeredPane layeredPane = new JLayeredPane();
        frame.setContentPane(layeredPane);

        panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.rotate(Math.toRadians(theta), this.getWidth() / 2, this.getHeight() / 2);
            }
        };
        panel.setBounds(0, 0, 1536, 864);
        panel.setBackground(new Color(255, 230, 240));
        panel.setLayout(null);

        CentralHexagon centralHexagon = new CentralHexagon(75);
        centralHexagon.setBounds(0, 0, 1536, 864);
        panel.add(centralHexagon);

        DrawLine drawLine = new DrawLine(75);
        drawLine.setBounds(-1000, -1000, 153600, 86400);
        panel.add(drawLine);


        Mahlar mahlar = new Mahlar(75);
        mahlar.setBounds(0, 0, 1536, 864);
        panel.add(mahlar);
        panel.setComponentZOrder(mahlar, 0);


        gameTimer = new GameTimer();
        gameTimer.setBounds(1250, 0, 300, 60);
        layeredPane.add(gameTimer, JLayeredPane.DRAG_LAYER);
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(pauseButton(), JLayeredPane.DRAG_LAYER);
        layeredPane.add(bestScore(), JLayeredPane.DRAG_LAYER);
    }

    public JButton pauseButton() {
        MakeButton pauseButton = new MakeButton("Pause");
        pauseButton.setBounds(-50, 0, 300, 60);
        pauseButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        pauseButton.setBorder(BorderFactory.createEtchedBorder());
        pauseButton.setBorder(BorderFactory.createRaisedBevelBorder());

        pauseButton.addActionListener(e -> {
            StopTimer();
            new PauseButton();
        });

        return pauseButton;
    }
    public JLabel bestScore() {
        MakeLabel bestScore = new MakeLabel("BEST SCORE : "+MainMenu.bestScore.getText());
        bestScore.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        bestScore.setBounds(1250, 75, 300, 75);

        bestScore.setOpaque(true);
        return bestScore;
    }
    public void StopTimer() {
        isGameOver = true;

        if (timer != null) timer.stop();

        if (gameTimer.timer != null) gameTimer.timer.stop();
        for (Timer time : Obstacles.timers){
            time.stop();
        }
    }
    public void RunTimer() {
        if (timer != null) timer.start();
        if (gameTimer.timer != null) gameTimer.timer.start();
        for (Timer time : Obstacles.timers){
            time.start();
        }
        isGameOver = false;
    }
    public void changeColor(){
        Color[]BackGround1 = {
                new Color(255, 230, 240),
                new Color(241, 226, 152),
                new Color(219, 244, 192, 255),
                new Color(169, 246, 225, 255),
        };
        panel.setBackground(BackGround1[i]);
        if(i==3)i=-1;
        i++;
    }
}

