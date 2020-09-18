package com.infosys.timetracker.tim.repsitory;

import com.infosys.timetracker.tim.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
