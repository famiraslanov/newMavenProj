package utils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public static org.json.simple.JSONObject getRandomCryptoPair(String responseBody, String key){
        JSONParser parser = new JSONParser();

        try {
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(responseBody);
            org.json.simple.JSONObject resultObject = (org.json.simple.JSONObject) jsonObject.get(SettingsConstants._result);

            org.json.simple.JSONObject pair = (org.json.simple.JSONObject) resultObject.get(key);

            return pair;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLastStringFromJsonObject(String responseBody){
        try {
            JSONParser parser = new JSONParser();
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(responseBody);

            String lastValue = (String) ((org.json.simple.JSONObject) jsonObject.get(SettingsConstants._result)).get(SettingsConstants._last);
            return lastValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

