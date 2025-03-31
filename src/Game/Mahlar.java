package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Mahlar extends JLabel {

    protected double theta=0;
    protected double CX=786;
    protected double CY=432;
    protected int r;


    public Mahlar(int r) {
        this.r=r;
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getX()>CX){
                    theta-=60;
                }
                else {
                    theta+=60;
                }
                repaint();
            }
        });
    }
    private Point RotatePoint(int x,int y){
        double newX = CX + (x - CX) * Math.cos(Math.toRadians(theta)) - (y - CY) * Math.sin(Math.toRadians(theta));
        double newY = CY + (x - CX) * Math.sin(Math.toRadians(theta)) + (y - CY) * Math.cos(Math.toRadians(theta));
        return new Point((int)newX, (int)newY);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x1=785;
        int y1=350;

        int x2=792;
        int y2=360;

        int x3=778;
        int y3=360;

        Point p1 = RotatePoint(x1,y1);
        Point p2 = RotatePoint(x2,y2);
        Point p3 = RotatePoint(x3,y3);

        Polygon triangle = new Polygon();
        triangle.addPoint(p1.x,p1.y);
        triangle.addPoint(p2.x,p2.y);
        triangle.addPoint(p3.x,p3.y);

        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(triangle);
    }
}
