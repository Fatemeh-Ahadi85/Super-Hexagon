package Game;

import javax.swing.*;
import java.awt.*;

public class MakeLabel extends JLabel {

    public MakeLabel(String text) {
        super(text);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);

    }
    public void paintComponent(Graphics g) {
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

        FontMetrics fm = g2d.getFontMetrics();///////////////////////////////////
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();
        g2d.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 4);

        g2d.dispose();

    }
}
