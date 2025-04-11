package Game;

import java.awt.*;

public class FirstType extends Obstacles {
    private double theta = 0;
    private Mahlar mahlar;

    public FirstType(double radius) {
        super(radius);
        mahlar = new Mahlar(75);
        mahlar.setBounds(0, 0, 2000, 2000);
        this.add(mahlar);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(5));

        mahlar.repaint();


        for (int i=0;i<3;i++) {
            g2d.setColor(new Color(5, 5, 5));
            g2d.fillPolygon(getPolygon());
            theta+=60;
        }
    }

    public Polygon getPolygon() {

        Polygon p = new Polygon();
        double x = CX + (radius * 10) * Math.cos(Math.toRadians(theta));
        double y = CY + (radius * 10) * Math.sin(Math.toRadians(theta));
        p.addPoint((int) x, (int) y);
        double xOuter = CX + (radius * 10.5) * Math.cos(Math.toRadians(theta));
        double yOuter = CY + (radius * 10.5) * Math.sin(Math.toRadians(theta));
        p.addPoint((int) xOuter, (int) yOuter);
        theta += 60;
        double xOuter1 = CX + (radius * 10.5) * Math.cos(Math.toRadians(theta));
        double yOuter1 = CY + (radius * 10.5) * Math.sin(Math.toRadians(theta));
        p.addPoint((int) xOuter1, (int) yOuter1);
        double X1 = CX + (radius * 10) * Math.cos(Math.toRadians(theta));
        double Y1 = CY + (radius * 10) * Math.sin(Math.toRadians(theta));
        p.addPoint((int) X1, (int) Y1);

        int x1 = 785, y1 = 350;
        int x2 = 792, y2 = 360;
        int x3 = 778, y3 = 360;

        double ceX = (x1 + x2 + x3) / 3.0;
        double ceY = (y1 + y2 + y3) / 3.0;

        double newX=mahlar.RotateX(ceX,ceY);
        double newY=mahlar.RotateY(ceX,ceY);

        if (p.contains(newX+1000, newY+1000)) {
            GamePanel gamePanel = new GamePanel();
            gamePanel.frame.remove(gamePanel.panel);
            GameOver gameOver = new GameOver();
            gameOver.fail();
        }

        return p;
    }
}
