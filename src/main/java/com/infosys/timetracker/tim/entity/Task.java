package com.infosys.timetracker.tim.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
public class Task {
    private Character appName;
    private Character groupId;

    @Id
    private Character incidentId;
    private Character incidentType;
    private Character summary;
    private Integer empId;
    private Timestamp submitDate;
    private Timestamp closedDate;
    private Character impact;
    private Character resolution;
    private Character resCateTier1;
    private Character status;
    private Timestamp respondedDate;
    private Character resCateTier3;
    private Timestamp targetDate;
    private Integer maintId;
    private Timestamp maintTs;
}
