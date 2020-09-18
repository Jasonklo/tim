package com.infosys.timetracker.tim.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Application {

    @Id
    private Character appName;

    private Character managerName;
    private Character area;
    private Integer maintId;
    private Timestamp maintTs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "application")
    private List<Task> tasks;
}
