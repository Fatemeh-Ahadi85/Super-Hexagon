package Game;

import javax.swing.*;
import java.util.Random;

public class Obstacles extends JLabel {

    protected double CX = 1786;
    protected double CY = 1432;
    protected double radius;
    protected Random random;
    protected int c;

    protected Obstacles(double radius,int c) {
        this.radius = radius;
        this.c = c;
        random = new Random();

    }
    public JLabel generateObstacles() {
        Obstacles obstacle = null;

        int choice = random.nextInt(2);
        if (choice == 0) {
            obstacle = new ThirdType(radius,c);
        }
        else if (choice == 1) {
            obstacle=new SecondType(radius,c);
        }
        else if(choice == 2) {
            obstacle=new FirstType(radius,c);
        }
        return obstacle;
    }
//        Timer timer = new Timer(50, e -> {
//            this.radius-=0.25;
//            repaint();
//        });
//        timer.start();
//    }
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setStroke(new BasicStroke(5));


//        for(int i = 0;i < 6;i++) {
//            Polygon p = new Polygon();
//            double x = CX + (radius * 10) * Math.cos(Math.toRadians(theta));
//            double y = CY + (radius * 10) * Math.sin(Math.toRadians(theta));
//            p.addPoint((int) x, (int) y);
//            double xOuter = CX + (radius * 10.5) * Math.cos(Math.toRadians(theta));
//            double yOuter = CY + (radius * 10.5) * Math.sin(Math.toRadians(theta));
//            p.addPoint((int) xOuter, (int) yOuter);
//            theta += 60;
//            double xOuter1 = CX + (radius * 10.5) * Math.cos(Math.toRadians(theta));
//            double yOuter1 = CY + (radius * 10.5) * Math.sin(Math.toRadians(theta));
//            p.addPoint((int) xOuter1, (int) yOuter1);
//            double x1 = CX + (radius * 10) * Math.cos(Math.toRadians(theta));
//            double y1 = CY + (radius * 10) * Math.sin(Math.toRadians(theta));
//            p.addPoint((int) x1, (int) y1);
//
//            g2d.setColor(new Color(5, 5, 5));
//            g2d.fillPolygon(p);
//
//        }
}
