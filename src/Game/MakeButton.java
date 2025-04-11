package Game;

import javax.swing.*;
import java.awt.*;

public class MakeButton extends JButton {

    public MakeButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Polygon p = new Polygon();

        p.addPoint(20,0 );
        p.addPoint(getWidth(),0 );
        p.addPoint(getWidth()-20,getHeight());
        p.addPoint(0,getHeight());

        g2d.setColor(new Color(220,220,220));
        g2d.fillPolygon(p);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(p);

        super.paintComponent(g);

    }

    @Override
    public boolean contains(int x, int y) {
        Polygon p = new Polygon();

        p.addPoint(20,0 );
        p.addPoint(getWidth(),0 );
        p.addPoint(getWidth()-20,getHeight());
        p.addPoint(0,getHeight());

        return p.contains(x, y);
    }
}
