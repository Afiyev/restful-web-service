package org.example.controller;

import org.example.entity.Employee;
import org.example.exception_handling.EmptyTableException;
import org.example.exception_handling.NoSuchEmployeeException;
import org.example.service.MyControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    private MyControllerService myControllerService;

    @Autowired
    public MyController(MyControllerService myControllerService) {
        this.myControllerService = myControllerService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() throws EmptyTableException {
        List<Employee> employees = myControllerService.getEmployees();
        if (employees.isEmpty()){
            throw new EmptyTableException();
        }
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) throws NoSuchEmployeeException {
        Employee employee = myControllerService.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException(id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        myControllerService.saveOrUpdate(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) throws NoSuchEmployeeException {
        Employee employee1 = myControllerService.getEmployee(employee.getId());
        if (employee1 == null) {
            throw new NoSuchEmployeeException(employee.getId());
        }
        myControllerService.saveOrUpdate(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) throws NoSuchEmployeeException {
        Employee employee = myControllerService.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException(id);
        }
        myControllerService.deleteEmployee(employee);
        return "Element with ID = " + id + " was deleted";

    }
}
