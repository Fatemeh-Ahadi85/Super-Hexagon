package Game;

import javax.swing.*;
import java.util.Random;

public class Obstacles extends JComponent {

    protected double CX = 1786;
    protected double CY = 1432;
    protected double radius;
    protected Random random;
    protected int i=0;
    public Timer timer;

    protected Obstacles(double radius) {
        this.radius = radius;
        random = new Random();
        timer = new Timer(10, e -> {
            this.radius -= 0.25;
            repaint();
        });
        timer.start();

    }
    public JComponent generateObstacles() {
        Obstacles obstacle = null;

        int choice = random.nextInt(3);
        if (choice == 0) {
            obstacle = new ThirdType(radius);
        }
        else if (choice == 1) {
            obstacle=new SecondType(radius);
        }
        else if(choice == 2) {
            obstacle=new FirstType(radius);
        }
        return obstacle;
    }
}
