package com.findquake.model.earthquakedata;

import lombok.Data;

import java.util.List;

@Data
public class Geometry {
    private String type;
    private List<Double> coordinates;
}
