package Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    protected JFrame frame;
    protected JPanel panel;
    protected double theta=0;


    public GamePanel() {
        Timer timer = new Timer(25,e ->{
            theta+=0.5;
            panel.repaint();
        });
        timer.start();
        frame = new JFrame();
        frame.setTitle("Super Hexagon");
        frame.setSize(1536, 864);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\super hexagon.png");
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);

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



        frame.add(panel);
        frame.setVisible(true);
    }

}
