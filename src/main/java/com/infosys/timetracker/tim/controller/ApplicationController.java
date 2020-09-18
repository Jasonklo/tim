package com.infosys.timetracker.tim.controller;

import com.infosys.timetracker.tim.entity.Application;
import com.infosys.timetracker.tim.repsitory.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/applications", produces = "application/json")
@CrossOrigin(origins = "*")
public class ApplicationController {

    private ApplicationRepository repo;

    @Autowired
    public ApplicationController(ApplicationRepository repo)
    {
        this.repo = repo;
    }
    @GetMapping
    public Iterable allApplications() { return  repo.findAll(); }

    @GetMapping("/{id}")
    public Optional<Application> byId(@PathVariable char id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void updateApplication(@PathVariable char id, @RequestBody Application application) {
        if (application.getAppName()!=(id)) {
            throw new IllegalStateException("Given employee's ID doesn't match the ID in the path.");
        }
        repo.save(application);
    }

    @PostMapping
    public ResponseEntity<Application> postApplication(@RequestBody Application application) {
        Application saved = repo.save(application);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/applications/" + application.getAppName()));
        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable char id) {
        repo.deleteById(id);
    }

}
