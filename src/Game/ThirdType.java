package Game;

import javax.swing.*;
import java.awt.*;

public class ThirdType extends Obstacles {
    public double theta = 0;
    private int m;

    protected ThirdType(double radius) {
        super(radius);
        m = random.nextInt(6);
        Timer timer = new Timer(10, e -> {
            this.radius -= 0.25;
            if (this.radius <= 0) {
                this.radius = 0;
            }
            repaint();
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(5));

        for (int i = 0; i < 6; i++) {
            if(i==m){
                continue;
            }
            g2d.setColor(new Color(0, 0, 0));
            g2d.fillPolygon(getPolygon(theta+(i*60)));
        }
    }
    public Polygon getPolygon(double angle) {
        Polygon p = new Polygon();

        double x = CX + (radius * 10) * Math.cos(Math.toRadians(angle));
        double y = CY + (radius * 10) * Math.sin(Math.toRadians(angle));
        p.addPoint((int) x, (int) y);

        double xOuter = CX + (radius * 10.5) * Math.cos(Math.toRadians(angle));
        double yOuter = CY + (radius * 10.5) * Math.sin(Math.toRadians(angle));
        p.addPoint((int) xOuter, (int) yOuter);

        angle += 60;

        double xOuter1 = CX + (radius * 10.5) * Math.cos(Math.toRadians(angle));
        double yOuter1 = CY + (radius * 10.5) * Math.sin(Math.toRadians(angle));
        p.addPoint((int) xOuter1, (int) yOuter1);

        double x1 = CX + (radius * 10) * Math.cos(Math.toRadians(angle));
        double y1 = CY + (radius * 10) * Math.sin(Math.toRadians(angle));
        p.addPoint((int) x1, (int) y1);

        return p;
    }
}
