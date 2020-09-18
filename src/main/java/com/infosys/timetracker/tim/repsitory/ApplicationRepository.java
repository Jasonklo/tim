package com.infosys.timetracker.tim.repsitory;

import com.infosys.timetracker.tim.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Character> {
}
