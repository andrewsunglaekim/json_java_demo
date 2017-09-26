import java.io.*;
import java.net.*;
import org.json.*;

public class Test {
  public static void main(String[] args) throws Exception {
    String stringUrl = "http://api.wunderground.com/api/f28a93cae85945b6/conditions/q/CA/San_Francisco.json";
    URL url = new URL(stringUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    int responseCode = con.getResponseCode();
    System.out.println("Sending get request : "+ url);
    System.out.println("Response code : "+ responseCode);

    BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
    String output;
    StringBuffer response = new StringBuffer();

    while ((output = in.readLine()) != null) {
      response.append(output);
    }
    in.close();

    //printing result from response
    System.out.println(response.toString());

    JSONObject weatherJson = new JSONObject(response.toString());
    JSONObject currentObs = weatherJson.getJSONObject("current_observation");
    double tempF = currentObs.getDouble("temp_f");
    System.out.println(tempF);
  }
}
