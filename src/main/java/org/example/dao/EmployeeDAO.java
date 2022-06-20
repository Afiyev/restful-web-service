package org.example.dao;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getEmployees();
    public Employee getEmployee(int id);
    public void saveOrUpdate(Employee employee);
    public void deleteEmployee(Employee employee);
}
