package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mahlar extends JLabel {

    public static double theta=0;
    protected double CX = 786;
    protected double CY = 432;
    protected double radius;
    public double centerX;
    public double centerY;

    public Mahlar(double r) {
        this.radius = r;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() > CX) {
                    theta -= 60.0;
                } else {
                    theta += 60;
                }
                repaint();
            }
        });
    }

    public double RotateX(double x, double y) {
        centerX = CX + (x - CX) * Math.cos(Math.toRadians(theta)) - (y - CY) * Math.sin(Math.toRadians(theta));
        return centerX;
    }
    public double RotateY(double x, double y) {
        centerY = CY + (x - CX) * Math.sin(Math.toRadians(theta)) + (y - CY) * Math.cos(Math.toRadians(theta));
        return centerY;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x1 = 785, y1 = 350;
        int x2 = 792, y2 = 360;
        int x3 = 778, y3 = 360;

        Polygon triangle = new Polygon();
        triangle.addPoint((int) RotateX(x1, y1), (int) RotateY(x1, y1));
        triangle.addPoint((int) RotateX(x2, y2), (int) RotateY(x2, y2));
        triangle.addPoint((int) RotateX(x3, y3), (int) RotateY(x3, y3));

        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(triangle);
    }
}
