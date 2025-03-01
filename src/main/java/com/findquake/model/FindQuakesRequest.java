package com.findquake.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindQuakesRequest {
    private Double minMagnitude;
    private Integer countOfDays;
}
