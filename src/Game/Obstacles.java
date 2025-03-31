package Game;

import javax.swing.*;
import java.util.Random;

public class Obstacles extends JLabel {

    protected double CX = 1786;
    protected double CY = 1432;
    protected double radius;
    protected Random random;
    protected double save;

    protected Obstacles(double radius) {
        save = radius;
        this.radius = radius;
        random = new Random();

    }
    public JLabel generateObstacles() {
        Obstacles obstacle = null;

        int choice = random.nextInt(2);
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
