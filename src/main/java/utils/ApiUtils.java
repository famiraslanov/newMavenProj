package utils;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;


public class ApiUtils {
    public static String getResponse(String apiUrl) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(apiUrl)
                .request(MediaType.APPLICATION_JSON)
                .get();
        return response.readEntity(String.class);
    }

    public static String getResponse(String apiUrl, String cryptoName, long dateStamp) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(String.format(apiUrl, cryptoName, dateStamp))
                .request(MediaType.APPLICATION_JSON)
                .get();
        return response.readEntity(String.class);
    }

}
