import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class History extends JFrame{
    public JList<User> jList;
    public JScrollPane jScrollPane;
    public Gson gson = new Gson();

    public History() {
        refreshList();

        jList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jList.setBackground(new Color(220,220,220));
        jList.setForeground(new Color(132, 62, 207, 187));
        jScrollPane = new JScrollPane(jList);

        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\history.png");

        this.setTitle("History");
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setBounds(600,200,350, 500);
        this.add(jScrollPane);
        jScrollPane.setBounds(0, 0, 340, 470);
        this.setVisible(true);
    }
    public java.util.List<User> getUsers() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("User.json"));
            User[] user = gson.fromJson(bufferedReader, User[].class);

            return user != null ? List.of(user) : new ArrayList<>();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void refreshList() {
        List<User> users = getUsers();
        jList = new JList<>(users.toArray(new User[users.size()+1]));
        revalidate();
    }
}
