package com.rishabh.departmentservice.client;

import com.rishabh.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {
    @GetExchange("/employee/department/{id}")
    public List<Employee> getByDepartment(@PathVariable("id") Long id);
}

