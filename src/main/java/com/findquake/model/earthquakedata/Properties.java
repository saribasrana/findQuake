package com.findquake.model.earthquakedata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Properties {
    private double mag;
    private String place;
    private long time;
    private long updated;
    private Integer tz;
    private String url;
    private String detail;
    private Integer felt;
    private Double cdi;
    private Double mmi;
    private String alert;
    private String status;
    private int tsunami;
    private int sig;
    private String net;
    private String code;
    private String ids;
    private String sources;
    private String types;
    private Integer nst;
    private Double dmin;
    private Double rms;
    private Double gap;
    private String magType;

    @JsonProperty("type")
    private String featureType;
}
