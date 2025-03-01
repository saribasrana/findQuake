package com.findquake.model;

import com.findquake.model.earthquakedata.Feature;
import com.findquake.model.earthquakedata.Metadata;
import lombok.Data;

import java.util.List;

@Data
public class FindQuakesResponse {
    private String type;

    //API Information
    private Metadata metadata;


    private List<Double> bbox;

    //Quakes
    private List<Feature> features;
}
