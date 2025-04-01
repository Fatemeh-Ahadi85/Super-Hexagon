package Game;

import javax.swing.*;
import java.util.Random;


public class Obstacles extends JComponent {

    protected double CX = 1786;
    protected double CY = 1432;
    protected double radius;
    protected Random random;
    protected int theta = 0;
    protected double points[][];
    protected int m;

    public Obstacles(double radius) {
        this.radius = radius;
        random = new Random();
        m=random.nextInt(6);
        Timer timer = new Timer(10, e -> {
            this.radius -= 0.25;
            repaint();
        });
        timer.start();
    }

    public JComponent generateObstacles() {
        JComponent obstacles1 = new Obstacles(radius);
        int angle;

        int choice = random.nextInt(3);
        if (choice == 0) {
            for (int i = 0; i < 3; i++) {
                angle = theta+(i)*60 +120;
                NewObstacles newObstacle = new NewObstacles(radius, angle);
                newObstacle.setBounds(0, 0, 2000, 2000);
                obstacles1.add(newObstacle);
            }
        }
        else if (choice == 1) {
            theta += 60;
            for (int i = 0; i < 3; i++) {
                angle = theta+(i)*60+120;
                NewObstacles newObstacle = new NewObstacles(radius, angle);
                newObstacle.setBounds(0, 0, 2000, 2000);  // مقداردهی برای دیده شدن
                obstacles1.add(newObstacle);

            }
        }
        else {
            for (int i = 0; i < 6; i++) {
                if (i == m) {
                    continue;
                }
                angle = theta + (i) * 60;
                NewObstacles newObstacle = new NewObstacles(radius, angle);
                newObstacle.setBounds(0, 0, 2000, 2000);  // مقداردهی برای دیده شدن
                obstacles1.add(newObstacle);

            }
        }
        return obstacles1;
    }
}

























//    public void checkObstacles(Panel panel,ArrayList<Obstacles> obstaclesArrayList) {
//        if(radius<=7.5){
//            panel.remove(this);
//            panel.revalidate();
//            panel.repaint();
//        }
//        else if(!obstaclesArrayList.contains(this)){
//            obstaclesArrayList.add(this);
//        }

