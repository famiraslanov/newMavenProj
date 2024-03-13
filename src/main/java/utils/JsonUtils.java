package utils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    public static String getJsonValue(String jsonFileName, String columnName) { try {
        String content = new String(Files.readAllBytes(Paths.get(jsonFileName)));

        JSONObject jsonObject = new JSONObject(content);

        return jsonObject.getString(columnName);
    } catch (IOException e) {
        e.printStackTrace();
    }
        return null;
    }

}

