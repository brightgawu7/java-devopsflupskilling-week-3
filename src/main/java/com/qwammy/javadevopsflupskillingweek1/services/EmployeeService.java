package com.qwammy.javadevopsflupskillingweek1.services;

import com.qwammy.javadevopsflupskillingweek1.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final Map<UUID, Employee> employeeMap = new HashMap<>();

    public Employee addEmployee(Employee employee) {
        UUID uuid = UUID.randomUUID();
        employee.setId(uuid.toString());
        employeeMap.put(uuid, employee);
        return employee;
    }

    public Collection<Employee> getAllEmployees() {
        return employeeMap.values();
    }

    public Optional<Employee> getEmployeeById(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return Optional.ofNullable(employeeMap.get(uuid));
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return null;
        }
        if (employeeMap.containsKey(uuid)) {
            updatedEmployee.setId(uuid.toString());
            employeeMap.put(uuid, updatedEmployee);
            return updatedEmployee;
        }
        return null;
    }

    public void deleteEmployee(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            return;
        }
        employeeMap.remove(uuid);
    }
}
