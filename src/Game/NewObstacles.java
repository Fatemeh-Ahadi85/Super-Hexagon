package Game;

import java.awt.*;

public class NewObstacles extends Obstacles{

    private Point point;
    private double angle;
    private double r;

    public NewObstacles(double radius,double angle) {
        super(radius);
        this.point = new Point();
        this.angle = angle;
        r=12;
        repaint();
    }
    public Point getPoint(){
        double x = CX + (radius * r) * Math.cos(Math.toRadians(angle));
        double y = CY + (radius * r) * Math.sin(Math.toRadians(angle));
        point.setLocation(x, y);
        return point;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(5));

        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(getPolygon());repaint();
    }
    public Polygon getPolygon() {
        Polygon obstacles = new Polygon();
        r = 12;
        for (int i = 0; i < 4 ; i++) {
            obstacles.addPoint(getPoint().x, getPoint().y);
            if(i==0){
                r=12.5;
            }
            if(i==1){
                theta+=60;
            }
            if(i==2){
                r=12;
            }
        }
        return obstacles;
    }
}
