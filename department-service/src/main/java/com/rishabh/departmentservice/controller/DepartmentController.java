package com.rishabh.departmentservice.controller;

import com.rishabh.departmentservice.client.EmployeeClient;
import com.rishabh.departmentservice.model.Department;
import com.rishabh.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping()
    public Department addDepartment(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping()
    public List<Department> findAll() {
        LOGGER.info("Department find all");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        LOGGER.info("Department find : id={}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find all");
        List<Department> departmentList = departmentRepository.findAll();
        departmentList.forEach(department -> department.setEmployeeList(employeeClient.getByDepartment(department.getId())));
        return departmentList;
    }

}
