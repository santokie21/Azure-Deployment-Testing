package io.noobi.azure.service;

import io.noobi.azure.model.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> getAllEmployees();
  Employee getEmployeeById(Integer id);
  void addEmployee(Employee employee);
}
