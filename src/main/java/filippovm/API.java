/**
 * Mikhail Filippov
 * 02/02/2025
 * PLaying around with Maven and Java APIs
 */

package filippovm;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class API {
    public static Countries call() {
        try {
            Countries countries;
            Gson gson = new Gson();
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://countries-api-abhishek.vercel.app/countries"))
                    .GET()
                    .build();
            HttpResponse<String> getResponse = HttpClient.newHttpClient()
                    .send(getRequest, BodyHandlers.ofString());

            countries = gson.fromJson(getResponse.body(), Countries.class);
//            System.out.println("Country: " + country.getName());
//            System.out.println("Capital: " + country.getCapital());
//            System.out.println("Borders: " + country.getBorders());

            return countries;

        } catch (URISyntaxException e) {
            System.err.println("URI is invalid");
        } catch (IOException e) {
            System.err.println("IOException");
        } catch (InterruptedException e) {
            System.err.println("InterruptedException");
        }
        return null;
    }
}