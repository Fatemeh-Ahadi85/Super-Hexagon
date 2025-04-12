import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Obstacles extends JComponent {

    protected double CX = 1786;
    protected double CY = 1432;
    protected double radius;
    protected Random random;
    protected int i=0;
    public Timer timer;

    public static ArrayList<Timer> timers=new ArrayList<>();
    public static ArrayList<Timer> deleteTimer=new ArrayList<>();

    protected Obstacles(double radius) {
        this.radius = radius;
        random = new Random();
        timer = new Timer(25, e -> {
            this.radius -= 0.55;
            if (this.radius <= 7.5) {
                deleteTimer.add(timer);
            }
            repaint();
        });
        timers.add(timer);
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
