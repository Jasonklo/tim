package com.infosys.timetracker.tim.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private Character incidentId;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="AppName", insertable = false, updatable = false)
    private Application application;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="groupId", insertable = false, updatable = false)
    private Group group;

    private Character incidentType;
    private Character summary;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="empId", insertable = false, updatable = false)
    private Employee employee;
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


