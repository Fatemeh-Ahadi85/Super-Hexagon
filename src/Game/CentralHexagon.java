package Game;

import javax.swing.*;
import java.awt.*;

public class CentralHexagon extends JLabel {

    protected double CX=786;
    protected double CY=432;
    protected int radius;

    public CentralHexagon(int radius) {
        this.radius = radius;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setStroke(new BasicStroke(5));

        Polygon hexagon = new Polygon();
        double theta=0;
        for(int i=0;i<6;i++){
            double x = CX + radius * Math.cos(Math.toRadians(theta));
            double y = CY + radius * Math.sin(Math.toRadians(theta));

            hexagon.addPoint((int) x, (int) y);
            theta += 60;
        }
        g2d.setColor(new Color(220, 220, 220));
        g2d.drawPolygon(hexagon);
    }
}
