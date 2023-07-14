import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User>users = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("users.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (List<User>)ois.readObject();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Menu.start(users);
    }
}