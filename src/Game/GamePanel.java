package Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    protected JFrame frame;
    protected JPanel panel;
    protected double theta=0;
    protected Timer timer;
    protected Timer timer1;
    protected Timer timer2;

    public GamePanel() {

        timer = new Timer(25,e ->{
            theta+=0.5;
            panel.repaint();
        });
        timer.start();
        frame = new JFrame();
        frame.setTitle("Super Hexagon");
        frame.setSize(1536, 864);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\super hexagon.png");
        frame.setIconImage(icon.getImage());

        JLayeredPane layeredPane = new JLayeredPane();
        frame.setContentPane(layeredPane);

        panel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.rotate(Math.toRadians(theta), this.getWidth()/2, this.getHeight()/2);
            }
        };

        panel.setBounds(0, 0, 1536, 864);
        panel.setBackground(new Color(255,230,240));
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
                            if(((Obstacles) com).timer!=null) {
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
        timer1 = new Timer(5000,e ->{

            Obstacles obstacles = new Obstacles(75);
            JComponent newObstacles = obstacles.generateObstacles();
            newObstacles.setBounds(-1000, -1000, 3000, 3000);
            panel.add(newObstacles);
            panel.setComponentZOrder(newObstacles, 1);
        });
        timer1.start();

        GameTimer gameTimer = new GameTimer();
        gameTimer.setBounds(400,0,200,50);
        layeredPane.add(gameTimer,JLayeredPane.DRAG_LAYER);

        layeredPane.add(panel,JLayeredPane.DEFAULT_LAYER);

        frame.setVisible(true);
    }
}
