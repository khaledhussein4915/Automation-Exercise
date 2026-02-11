package Utils;
import PojoClass.ContactUs;
import PojoClass.User;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class HelperClass {

//    public static User readJsonFile(String filePath) {
//        Gson gson = new Gson();
//
//        try (Reader reader = new FileReader(filePath)) {
//            // Convert JSON File to Java Object
//            return gson.fromJson(reader, User.class);
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//            return null;
//        }
//    }
//
//    public static ContactUs getContactUsData(String filePath) {
//        Gson gson = new Gson();
//        ContactUs data = null;
//        try {
//            // بنفتح الملف ونقول لـ Gson صب الداتا جوه قالب الـ POJO
//            FileReader reader = new FileReader(filePath);
//            data = gson.fromJson(reader, ContactUs.class);
//        } catch (FileNotFoundException e) {
//            System.out.println("الملف مش موجود في المسار ده: " + filePath);
//        }
//        return data;
//    }

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
