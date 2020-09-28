package com.infosys.timetracker.tim.controller;

import com.infosys.timetracker.tim.entity.Employee;
import com.infosys.timetracker.tim.repsitory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

import java.util.Optional;

@RestController
@RequestMapping(path="/employees", produces="application/json")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }

    private EmployeeRepository empRepo;

    @Autowired
    public EmployeeController(EmployeeRepository empRepo)
    {
        this.empRepo = empRepo;
    }

    @GetMapping
    public Iterable<Employee> allEmployees() {
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> byId(@PathVariable Long id) {
        return empRepo.findById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (employee.getEmpId()!=(id)) {
            throw new IllegalStateException("Given employee's ID doesn't match the ID in the path.");
        }
        empRepo.save(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
        Employee saved = empRepo.save(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/employees/" + employee.getEmpId()));
        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        empRepo.deleteById(id);
    }


}
