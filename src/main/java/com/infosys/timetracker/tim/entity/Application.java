package com.infosys.timetracker.tim.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
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
