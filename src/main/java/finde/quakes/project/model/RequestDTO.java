package finde.quakes.project.model;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class RequestDTO implements Serializable {

    private String country;
    private Integer countOfDays;

}
