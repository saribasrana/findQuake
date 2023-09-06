package com.findquake;


import com.findquake.model.Earthquake;
import com.findquake.model.FindQuakesRequest;
import com.findquake.service.FindQuakeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindQuakeController {

    private final FindQuakeService findQuakeService;

    public FindQuakeController(FindQuakeService findQuakeService) {
        this.findQuakeService = findQuakeService;
    }

    @GetMapping("/earthquakes")
    public List<Earthquake> findQuake(@RequestBody FindQuakesRequest findQuakesRequest){
        return findQuakeService.findQuakes(findQuakesRequest);
    }
}
