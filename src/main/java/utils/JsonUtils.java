package utils;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    public static String getJsonValue(String jsonFileName, String columnName) { try {
        // Read JSON file content into a string
        String content = new String(Files.readAllBytes(Paths.get(jsonFileName)));

        // Parse JSON string into a JSONObject
        JSONObject jsonObject = new JSONObject(content);

        // Retrieve the string value associated with the "kraken" key
        return jsonObject.getString(columnName);
    } catch (IOException e) {
        e.printStackTrace();
    }
        return null; // Return null if there's an error
    }
}

