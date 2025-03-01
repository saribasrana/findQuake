package com.findquake;

import com.findquake.model.FindQuakesRequest;
import com.findquake.model.earthquakedata.Feature;
import com.findquake.service.FindQuakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FindQuakeController {

    private final FindQuakeService findQuakeService;

    public FindQuakeController(FindQuakeService findQuakeService) {
        this.findQuakeService = findQuakeService;
    }

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("findQuakesRequest", new FindQuakesRequest());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Model model, FindQuakesRequest findQuakesRequest) {
        List<Feature> features = findQuakeService.findQuakes(findQuakesRequest);
        model.addAttribute("features", features);
        return "earthquakes";
    }

    @GetMapping("/earthquakes")
    public String getEarthquakes(Model model) {
        return "earthquakes";
    }
}
