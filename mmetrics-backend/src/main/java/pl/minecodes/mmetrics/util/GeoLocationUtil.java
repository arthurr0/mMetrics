package pl.minecodes.mmetrics.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class GeoLocationUtil {

  private final static HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

  public static String getCountry(String address) {
    HttpRequest request = HttpRequest.newBuilder(URI.create("https://mgeo.minecodes.pl/api/v1/geo/country?address=" + address))
        .GET()
        .header("apiKey", "very_secret_api_key").build();

    try {
      HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
      JsonObject country = JsonParser.parseString(response.body()).getAsJsonObject();
      return country.get("names").getAsJsonObject().get("en").getAsString();
    } catch (Exception e) {
      return "Unknown";
    }
  }
}
