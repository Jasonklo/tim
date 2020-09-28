package com.infosys.timetracker.tim.repsitory;

import com.infosys.timetracker.tim.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "application", path = "application")
public interface ApplicationRepository extends JpaRepository<Application, Character> {
}
