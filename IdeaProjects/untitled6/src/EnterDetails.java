import javax.swing.*;
import java.awt.*;

public class EnterDetails{
    public JFrame frame1;
    public JTextField textField;
    public EnterDetails() {
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\icon.jpg");
        frame1 = new JFrame();
        frame1.setTitle("Enter Details");
        frame1.setSize(500, 300);
        frame1.setLocation(518,282);
        frame1.setLayout(null);
        frame1.setIconImage(icon.getImage());

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 500, 300);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(TextField());
        panel.add(icon());
        panel.add(getLabel());
        panel.add(getButton1());
        panel.add(getButton2());

        frame1.add(panel);
        frame1.setVisible(true);

    }
    public JTextField TextField() {
        textField = new JTextField();
        textField.setBounds(245, 130, 200, 25);
        textField.setFont(new Font("Times and Romans",Font.PLAIN,15));
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.pink);

        return textField;
    }
    public JLabel icon(){
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\icon.jpg");
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setBounds(0, 0, 200, 270);

        return label;
    }
    public JLabel getLabel(){
        JLabel label = new JLabel();
        label.setText("  Enter Your UserName:");
        label.setFont(new Font("Times and Romans",Font.BOLD,15));
        label.setBounds(250,80,200,25);

        return label;
    }
    public JButton getButton1(){
        JButton button = new JButton();
        button.setText("Start");
        button.setFont(new Font("Times and Romans",Font.BOLD,15));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBounds(260,180,80,30);

        button.addActionListener(e -> {
            String Name = textField.getText();
            User user = new User();
            user.setName(Name);
            frame1.dispose();
            MainMenu.mainMenu.frame.remove(MainMenu.mainMenu.panel);
            new GamePanel();
        });
        return button;
    }
    public JButton getButton2(){
        JButton button = new JButton();
        button.setText("back");
        button.setFont(new Font("Times and Romans",Font.BOLD,15));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBounds(350,180,80,30);

        button.addActionListener(e -> {
            frame1.dispose();
        });

        return button;
    }

}
