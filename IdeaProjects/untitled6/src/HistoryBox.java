
import javax.swing.*;
import java.awt.*;


public class HistoryBox extends SettingBoxes{

    public static HistoryBox instance;
    public static HistoryBox getInstance(){
        if(instance == null){
            instance = new HistoryBox();
        }
        return instance;
    }
    @Override
    public JCheckBox box() {
        checkBox.setText("Enable save to history");
        checkBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        checkBox.setForeground(Color.black);
        checkBox.setFocusPainted(false);

        checkBox.addActionListener(e -> {
            if(checkBox.isSelected()){
               Save.flag=true;
            }
            else{
                Save.flag=false;
            }
        });
        return checkBox;
    }
}
