package Utils;
import PojoClass.User;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class HelperClass {

    public static User readJsonFile(String filePath) {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(filePath)) {
            // Convert JSON File to Java Object
            return gson.fromJson(reader, User.class);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
}
