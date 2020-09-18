package com.infosys.timetracker.tim.controller;

import com.infosys.timetracker.tim.entity.Application;
import com.infosys.timetracker.tim.entity.Task;
import com.infosys.timetracker.tim.repsitory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/tasks", produces = "application/json")
@CrossOrigin(origins = "*")
public class TaskController {
    private TaskRepository repo;

    @Autowired
    public TaskController(TaskRepository repo)
    {
        this.repo = repo;
    }
    @GetMapping
    public Iterable allTasks() { return  repo.findAll(); }

    @GetMapping("/{id}")
    public Optional<Task> byId(@PathVariable char id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable char id, @RequestBody Task task) {
        if (task.getIncidentId()!=(id)) {
            throw new IllegalStateException("Given incident ID doesn't match the ID in the path.");
        }
        repo.save(task);
    }

    @PostMapping
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        Task saved = repo.save(task);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/tasks/" + task.getIncidentId()));
        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable char id) {
        repo.deleteById(id);
    }

}
