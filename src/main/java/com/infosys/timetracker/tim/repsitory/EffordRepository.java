package com.infosys.timetracker.tim.repsitory;

import com.infosys.timetracker.tim.entity.Effort;
import com.infosys.timetracker.tim.entity.EffortId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EffordRepository extends JpaRepository<Effort, EffortId> {
}
