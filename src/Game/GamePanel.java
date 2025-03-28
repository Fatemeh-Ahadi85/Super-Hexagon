package Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel {

    protected JFrame frame;
    protected JPanel panel;

    public GamePanel() {
        frame = new JFrame();
        frame.setTitle("Super Hexagon");
        frame.setSize(1536, 864);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\super hexagon.png");
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 1536, 864);
        panel.setBackground(new Color(255,230,240));
        panel.setLayout(null);

        CentralHexagon centralHexagon = new CentralHexagon(60);
        centralHexagon.setBounds(0, 0, 1536, 864);
        centralHexagon.setBackground(new Color(255,230,240));
        panel.add(centralHexagon);

        frame.add(panel);
        frame.setVisible(true);
    }
}
