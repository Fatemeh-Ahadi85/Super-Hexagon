import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    protected JFrame frame;
    protected JPanel panel;
    protected double theta = 0;
    protected Timer timer;
    protected Timer timer1;
    protected Timer timer2;
    public static GamePanel gamePanel;
    public GameTimer gameTimer;


    public GamePanel() {
        gamePanel = this;
        timer = new Timer(25, e -> {
            theta += 0.5;
            panel.repaint();
        });
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
        timer2 = new Timer(25, e -> {
            SwingUtilities.invokeLater(() -> {
                for (Component com : panel.getComponents()) {
                    if (com instanceof Obstacles) {
                        if (((Obstacles) com).radius <= 7.5) {
                            if (((Obstacles) com).timer != null) {
                                ((Obstacles) com).timer.stop();
                            }
                            panel.remove(com);
                            panel.revalidate();
                            panel.repaint();
                        }
                    }
                }
            });
        });
        timer2.start();
        timer1 = new Timer(2000, e -> {

            Obstacles obstacles = new Obstacles(75);
            JComponent newObstacles = obstacles.generateObstacles();
            newObstacles.setBounds(-1000, -1000, 3000, 3000);
            panel.add(newObstacles);
            panel.setComponentZOrder(newObstacles, 1);
        });
        timer1.start();

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
        if (timer != null) timer.stop();
        if (timer1 != null) timer1.stop();
        if (timer2 != null) timer2.stop();
        if (gameTimer.timer != null) gameTimer.timer.stop();
        for (Component com : panel.getComponents()) {
            if (com instanceof Obstacles) {
                if (((Obstacles) com).timer != null) {
                    ((Obstacles) com).timer.stop();
                }
            }
        }
    }
    public void RunTimer() {
        if (timer != null) timer.start();
        if (timer1 != null) timer1.start();
        if (timer2 != null) timer2.start();
        if (gameTimer.timer != null) gameTimer.timer.start();
        for (Component com : panel.getComponents()) {
            if (com instanceof Obstacles) {
                if (((Obstacles) com).timer != null) {
                    ((Obstacles) com).timer.start();
                }
            }
        }
    }
}

