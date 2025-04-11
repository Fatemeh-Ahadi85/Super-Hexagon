import javax.swing.*;
import java.awt.*;


public class History extends JFrame{
    public JList<User> jList;
    public JScrollPane jScrollPane;
    public History() {
        jList = new JList<>(Save.getUsers().toArray(new User[0]));
        jList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jList.setBackground(new Color(220,220,220));
        jList.setForeground(new Color(132, 62, 207, 187));
        jScrollPane = new JScrollPane(jList);

        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\history.png");

        this.setTitle("History");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(600,200,300, 500);
        this.add(jScrollPane);
        jScrollPane.setBounds(0, 0, 290, 500);
        this.setVisible(true);
    }
}
