package finde.quakes.project.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class QuakeDTO implements Serializable {

    private String place;
    private BigDecimal mag;
    private Date time;

}
