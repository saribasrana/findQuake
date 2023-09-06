package com.findquake.service;


import com.findquake.model.Earthquake;
import com.findquake.model.FindQuakesRequest;

import java.util.List;

public interface FindQuakeService {

    public List<Earthquake> findQuakes(FindQuakesRequest findQuakesRequest);

}
