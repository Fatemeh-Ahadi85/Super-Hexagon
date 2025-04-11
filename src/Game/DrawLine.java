package Game;

import javax.swing.*;
import java.awt.*;

public class DrawLine extends JLabel {

    protected double CX=1786;
    protected double CY=1432;
    protected int radius;

    public DrawLine(int radius) {
        this.radius = radius;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(5));

        double theta = 0;

        for(int i = 0;i < 6;i++) {
            Polygon p = new Polygon();
            double x = CX + radius * Math.cos(Math.toRadians(theta));
            double y = CY + radius * Math.sin(Math.toRadians(theta));
            p.addPoint((int) x, (int) y);
            double xOuter = CX + (radius * 5000) * Math.cos(Math.toRadians(theta));
            double yOuter = CY + (radius * 5000) * Math.sin(Math.toRadians(theta));
            p.addPoint((int) xOuter, (int) yOuter);
            theta += 60;
            double xOuter1 = CX + (radius * 5000) * Math.cos(Math.toRadians(theta));
            double yOuter1 = CY + (radius * 5000) * Math.sin(Math.toRadians(theta));
            p.addPoint((int) xOuter1, (int) yOuter1);
            double x1 = CX + radius * Math.cos(Math.toRadians(theta));
            double y1 = CY + radius * Math.sin(Math.toRadians(theta));
            p.addPoint((int) x1, (int) y1);

            if (i % 2 == 0) {
                g2d.setColor(new Color(220,220,220));
                g2d.fillPolygon(p);
            }
        }
    }
}
