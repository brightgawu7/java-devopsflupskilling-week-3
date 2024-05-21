package com.qwammy.javadevopsflupskillingweek1;


import com.qwammy.javadevopsflupskillingweek1.entities.Employee;
import com.qwammy.javadevopsflupskillingweek1.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testAddAndGetEmployee() {
        // Add an employee
        Employee employeeToAdd = new Employee();
        Employee addedEmployee = employeeService.addEmployee(employeeToAdd);

        assertNotNull(addedEmployee.getId());
        assertEquals(employeeToAdd.getName(), addedEmployee.getName());
        assertEquals(employeeToAdd.getSalary(), addedEmployee.getSalary());

        // Retrieve the added employee by ID
        Optional<Employee> retrievedEmployee = employeeService.getEmployeeById(addedEmployee.getId());

        assertTrue(retrievedEmployee.isPresent());
        assertEquals(addedEmployee, retrievedEmployee.get());
    }

    @Test
    void testUpdateEmployee() {
        // Add an employee
        Employee employeeToAdd = new Employee();
        Employee addedEmployee = employeeService.addEmployee(employeeToAdd);

        // Update the employee's details
        Employee updatedEmployee = new Employee();
        updatedEmployee.setName("Updated Name");
        updatedEmployee.setSalary(1000.0);

        Employee result = employeeService.updateEmployee(addedEmployee.getId(), updatedEmployee);

        assertNotNull(result);
        assertEquals(updatedEmployee.getName(), result.getName());
        assertEquals(updatedEmployee.getSalary(), result.getSalary());
        assertEquals(addedEmployee.getId(), result.getId());
    }

    @Test
    void testDeleteEmployee() {
        // Add an employee
        Employee employeeToAdd = new Employee();
        Employee addedEmployee = employeeService.addEmployee(employeeToAdd);

        // Delete the employee
        employeeService.deleteEmployee(addedEmployee.getId());

        // Verify the employee is deleted
        Optional<Employee> deletedEmployee = employeeService.getEmployeeById(addedEmployee.getId());
        assertFalse(deletedEmployee.isPresent());
    }
}
