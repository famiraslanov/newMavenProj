package utils;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EndpointUtils {

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
