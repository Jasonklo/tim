package com.infosys.timetracker.tim.repsitory;

import com.infosys.timetracker.tim.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Character> {
}
