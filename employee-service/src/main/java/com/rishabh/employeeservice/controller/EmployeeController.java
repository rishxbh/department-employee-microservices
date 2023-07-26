package com.rishabh.employeeservice.controller;

import com.rishabh.employeeservice.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rishabh.employeeservice.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee Employee) {
        LOGGER.info("Employee add: {}", Employee);
        return employeeRepository.addEmployee(Employee);
    }

    @GetMapping()
    public List<Employee> findAll() {
        LOGGER.info("Employee find all");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find : id={}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> getByDepartment(@PathVariable("id") Long id) {
        LOGGER.info("Find all employee with departmentId={}", id);
        return employeeRepository.getByDepartment(id);
    }

}
