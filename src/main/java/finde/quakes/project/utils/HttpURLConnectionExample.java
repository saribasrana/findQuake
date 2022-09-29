package finde.quakes.project.utils;

import finde.quakes.project.model.RequestDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

public class HttpURLConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";

    public static String sendGET(RequestDTO requestDTO) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String url = GET_URL;
        if (!isNull(requestDTO.getCountOfDays())) {
            Integer count = requestDTO.getCountOfDays();
            LocalDate now = LocalDate.now();
            LocalDate start = LocalDate.now().minusDays(count);
            url = url.concat("&starttime=" + start + "&endtime=" + now);
        }
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();

        } else {
            System.out.println("GET request not worked");
        }
        return "No Earthquakes were recorded";
    }

}
