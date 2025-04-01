package Game;

import java.awt.*;

public class FirstType extends Obstacles {
    private double theta = 0;
    public double x;
    public double y;
    public double x1;
    public double y1;
    public double xOuter;
    public double yOuter;
    public double xOuter1;
    public double yOuter1;
    public FirstType(double radius) {
        super(radius);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(5));

        for (int i=0;i<3;i++) {
            g2d.setColor(new Color(5, 5, 5));
            g2d.fillPolygon(getPolygon());
            theta+=60;
        }
    }
    public Polygon getPolygon() {

        Polygon p = new Polygon();
        x = CX + (radius * 10) * Math.cos(Math.toRadians(theta));
        y = CY + (radius * 10) * Math.sin(Math.toRadians(theta));
        p.addPoint((int) x, (int) y);
        xOuter = CX + (radius * 10.5) * Math.cos(Math.toRadians(theta));
        yOuter = CY + (radius * 10.5) * Math.sin(Math.toRadians(theta));
        p.addPoint((int) xOuter, (int) yOuter);
        theta += 60;
        xOuter1 = CX + (radius * 10.5) * Math.cos(Math.toRadians(theta));
        yOuter1 = CY + (radius * 10.5) * Math.sin(Math.toRadians(theta));
        p.addPoint((int) xOuter1, (int) yOuter1);
        x1 = CX + (radius * 10) * Math.cos(Math.toRadians(theta));
        y1 = CY + (radius * 10) * Math.sin(Math.toRadians(theta));
        p.addPoint((int) x1, (int) y1);

        return p;
    }
}
