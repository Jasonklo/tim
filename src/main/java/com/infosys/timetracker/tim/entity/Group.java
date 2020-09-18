package com.infosys.timetracker.tim.entity;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@RestResource(rel="group", path="group")
public class Group implements Serializable {

    @Id
    private Character groupId;
    private Character groupName;
    private Integer maintId;
    private Timestamp maintTs;

    @OneToMany(mappedBy = "group")
    private List<Task> tasks;

    @OneToMany(mappedBy = "group")
    private List<Employee> employees;


}
