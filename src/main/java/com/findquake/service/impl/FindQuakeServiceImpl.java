package com.findquake.service.impl;

import com.findquake.model.Earthquake;
import com.findquake.model.FindQuakesRequest;
import com.findquake.model.FindQuakesResponse;
import com.findquake.service.FindQuakeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FindQuakeServiceImpl implements FindQuakeService {

    @Value("${api.url}")
    private String apiUrl;

    private RestTemplate restTemplate;

    @Override
    public List<Earthquake> findQuakes(FindQuakesRequest findQuakesRequest) {

        // Calculate the start date based on the given number of days
        Date startDate = calculateStartDate(findQuakesRequest.getCountOfDays());

        // Create request parameters
        Map<String, String> params = new HashMap<>();
        params.put("format", "geojson");
        params.put("starttime", formatDate(startDate));
        params.put("endtime", formatDate(new Date()));
        params.put("minmagnitude", String.valueOf(findQuakesRequest.getMinMagnitude()));
        params.put("eventtype", "earthquake");
        params.put("orderby", "time");

        // Make a GET request to the USGS API
        String url = apiUrl + "?format={format}&starttime={starttime}&endtime={endtime}&minmagnitude={minmagnitude}&eventtype={eventtype}&orderby={orderby}";
        FindQuakesResponse response = restTemplate.getForObject(url, FindQuakesResponse.class, params);

        if (response != null) {
            return response.getEarthquakes();
        } else {
            return Collections.emptyList();
        }
    }

    private Date calculateStartDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -days);
        return calendar.getTime();
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

}
