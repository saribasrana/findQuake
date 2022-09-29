package finde.quakes.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ResultDTO implements Serializable {

    private String type;

    private List<QuakeDTO> features;


}
