package com.infosys.timetracker.tim.repsitory;


import com.infosys.timetracker.tim.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "task", path = "task")
public interface TaskRepository extends JpaRepository<Task, Character> {
            Page<Task> findByAssignee(Integer empId, Pageable pageable);
            List<Task> findByGroup(Character groupId, Pageable pageable);
            List<Task> findByApplication(Character appName, Pageable pageable);
            List<Task> findBySubmitDate(Timestamp submitStart, Timestamp submitEnd, Pageable pageable);


}

//Assignee
//Group
//Application
//Date range

