package com.infosys.timetracker.tim.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
public class Effort {
    @Id
    private int empId;
    @Id
    private Date weekStart;
    @Id
    private char intcidentId;

    private double mon;
    private double tue;
    private double wed;
    private double thr;
    private double fri;
    private double sat;
    private double sun;
    private int maintId;
    private Timestamp maintTs;

}
