package finde.quakes.project.controller;

import finde.quakes.project.model.RequestDTO;
import finde.quakes.project.utils.HttpURLConnectionExample;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.util.Objects.isNull;


@RestController
public class mainController {

    @GetMapping("/main")
    public String main(@RequestParam(name = "country", required = false) String country, @RequestParam(name = "countOfDays", required = false) String countOfDays, Model model) throws IOException {
        RequestDTO requestDTO = RequestDTO.builder().build();
        if (!isNull(country)) {
            requestDTO.setCountry(country);
        }
        if (!isNull(countOfDays)) {
            requestDTO.setCountOfDays(Integer.valueOf(countOfDays));
        }
        return HttpURLConnectionExample.sendGET(requestDTO);
    }
}
