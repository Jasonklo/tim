package com.infosys.timetracker.tim.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Application {

    @Id
    private Character appName;

    private Character managerName;
    private Character area;
    private Integer maintId;
    private Timestamp maintTs;
}
