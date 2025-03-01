package com.findquake.service;


import com.findquake.model.FindQuakesRequest;
import com.findquake.model.earthquakedata.Feature;

import java.util.List;

public interface FindQuakeService {

    List<Feature> findQuakes(FindQuakesRequest findQuakesRequest);

}
