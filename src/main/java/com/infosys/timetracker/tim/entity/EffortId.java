package com.infosys.timetracker.tim.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

@Embeddable
@Data
public class EffortId implements Serializable {
    private Integer empId;
    private Date weekStart;
    private Character intcidentId;

}
