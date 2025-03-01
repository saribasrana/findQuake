package com.findquake.model.earthquakedata;

import lombok.Data;

@Data
public class Metadata {
    private long generated;
    private String url;
    private String title;
    private String api;
    private int count;
    private int status;
}
