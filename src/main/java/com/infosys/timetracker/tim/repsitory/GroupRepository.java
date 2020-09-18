package com.infosys.timetracker.tim.repsitory;

import com.infosys.timetracker.tim.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Character> {
}
