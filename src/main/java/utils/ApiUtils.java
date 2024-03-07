package utils;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


public class ApiUtils {
    public static String getRandomCryptoPair() {


        Client client = ClientBuilder.newClient();
        Response response = client.target("https://api.kraken.com/0/public").path("/Assets")
                .request(MediaType.APPLICATION_JSON)
                .get();
        System.out.println(response);
        return null;
    }
}
