package com.findquake.model.earthquakedata;

import lombok.Data;

@Data
public class Feature {
    private String type;
    private Properties properties;
    private Geometry geometry;
    private String id;
}
