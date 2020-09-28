package com.infosys.timetracker.tim.controller;

import com.infosys.timetracker.tim.entity.Group;
import com.infosys.timetracker.tim.repsitory.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/groups", produces="application/json")
@CrossOrigin(origins = "*")
public class GroupController {


    private GroupRepository groupRepo;

    @Autowired
    public GroupController(GroupRepository groupRepo)
    {
        this.groupRepo = groupRepo;
    }

    @GetMapping
    public Iterable<Group> allGroups() {
        return groupRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Group> byId(@PathVariable String id) {
        return groupRepo.findById(id);
    }

    @PutMapping("/{id}")
    public void updateGroup(@PathVariable String id, @RequestBody Group group) {
        if (group.getGroupId()!=(id)) {
            throw new IllegalStateException("Given group's ID doesn't match the ID in the path.");
        }
        groupRepo.save(group);
    }

    @PostMapping
    public ResponseEntity<Group> postEmployee(@RequestBody Group group) {
        Group saved = groupRepo.save(group);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/groups/" + group.getGroupId()));
        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        groupRepo.deleteById(id);
    }

}
