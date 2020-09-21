package com.infosys.timetracker.tim.controller;

import com.infosys.timetracker.tim.entity.Task;
import com.infosys.timetracker.tim.repsitory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/tasks", produces = "application/json")
@CrossOrigin(origins = "*")
public class TaskController {
    private TaskRepository taskRepo;

    @Autowired
    public TaskController(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping
    public Iterable allTasks() {
        return taskRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> byId(@PathVariable char id) {
        return taskRepo.findById(id);
    }

    @GetMapping
    public Page findByAssignee(@RequestParam("empId") Integer empId,
                               Pageable pageable) {
        if (empId == null) {
            return taskRepo.findAll(pageable);
        }else {
            return taskRepo.findByAssignee(empId, pageable);
        }
    }

    @GetMapping
    public List<Task> findByGroup(@RequestParam("groupId") Character groupId,
                                  Pageable pageable) {
        if (groupId == null) {
            return (List<Task>) taskRepo.findAll(pageable);
        } else {
            return taskRepo.findByGroup(groupId, pageable);

        }
    }

    @GetMapping
    public List findByApplication(@RequestParam("appName") Character appName,
                               Pageable pageable) {
        if (appName == null) {
            return (List) taskRepo.findAll(pageable);
        }else {
            return taskRepo.findByApplication(appName, pageable);
        }

    }

    @GetMapping
    public List findBySubmitDate(@RequestParam("submitStart") Timestamp submitStart,
                               @RequestParam("submitEnd") Timestamp submitEnd,
                               Pageable pageable) {
        if (submitStart == null || submitEnd == null) {
            return (List) taskRepo.findAll(pageable);
        }else {
            return taskRepo.findBySubmitDate(submitStart, submitEnd, pageable);
        }
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable char id, @RequestBody Task task) {
        if (task.getIncidentId()!=(id)) {
            throw new IllegalStateException("Given incident ID doesn't match the ID in the path.");
        }
        taskRepo.save(task);
    }

    @PostMapping
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        Task saved = taskRepo.save(task);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/tasks/" + task.getIncidentId()));
        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable char id) {
        taskRepo.deleteById(id);
    }

}
