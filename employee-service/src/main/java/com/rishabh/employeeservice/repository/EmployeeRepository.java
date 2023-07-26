package com.rishabh.employeeservice.repository;

import com.rishabh.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();
    public Employee addEmployee(Employee Employee) {
        employeeList.add(Employee);
        return Employee;
    }
    public Employee findById(Long id) {
        return employeeList.stream().filter(Employee -> Employee.getId().equals(id)).findFirst().orElseThrow();
    }
    public List<Employee> findAll() {
        return employeeList;
    }

    public List<Employee> getByDepartment(Long departmentId) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .toList();
    }
}
