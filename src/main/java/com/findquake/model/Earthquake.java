package com.findquake.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Earthquake {
    private String id;
    private String place;
    private Date timestamp;
    private Double magnitude;
}
