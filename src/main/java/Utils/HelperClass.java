package Utils;
import PojoClass.ContactUs;
import PojoClass.User;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class HelperClass {



    public static <T> T getData(String filePath, Class<T> modelClass) {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(filePath);
            // هيصب الداتا في النوع اللي إنت هتبعتهوله وقت النداء
            return gson.fromJson(reader, modelClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("الملف مش موجود: " + filePath);
        }
    }

}
