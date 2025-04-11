
import java.time.LocalDate;


public class User {
    private String name ;
    private String date;
    private String Record;
    public static User user;


    @Override
    public String toString() {
        return "name=" + name + ", date=" + date + ", Record=" + Record ;
    }
    public User() {
        user =this;
        this.date = LocalDate.now().toString();
    }
    public void setName(String name){
        this.name = name;
    }
    public void setTime(String Time){
        this.Record = Time;
    }

}
