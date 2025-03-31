package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Obstacles extends JLabel {

    protected double CX = 1786;
    protected double CY = 1432;
    protected double radius;
    protected Random random;

    protected Obstacles(double radius) {

        this.radius = radius;
        random = new Random();
        Timer timer = new Timer(10, e -> {
            this.radius -= 0.25;

            repaint();
        });
        timer.start();

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
    public void checkObstacles(Panel panel,ArrayList<Obstacles> obstaclesArrayList) {
        if(radius<=7.5){
            panel.remove(this);
            panel.revalidate();
            panel.repaint();
        }
        else if(!obstaclesArrayList.contains(this)){
            obstaclesArrayList.add(this);
        }
    }
}
