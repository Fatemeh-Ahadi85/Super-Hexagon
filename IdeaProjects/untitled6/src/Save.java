import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Save {

    public static final Gson gson = new Gson();
    public static List<User>list;
    public static boolean flag=true;

    public static void setGson(User user) {
        if(!flag) return;

        list = new ArrayList<>();
        list.addAll(getUsers());
        list.add(user);

        try (FileWriter fileWriter = new FileWriter("User.json")) {
            fileWriter.write(gson.toJson(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<User> getUsers() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("User.json"));
            User[] user = gson.fromJson(bufferedReader, User[].class);
            return user != null ? List.of(user) : new ArrayList<>();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
