package com.infosys.timetracker.tim.repsitory;

import com.infosys.timetracker.tim.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "group", path = "group")
public interface GroupRepository extends JpaRepository<Group, Character> {
}
