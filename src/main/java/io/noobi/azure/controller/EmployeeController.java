package io.noobi.azure.controller;

import io.noobi.azure.model.Employee;
import io.noobi.azure.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService){
    this.employeeService = employeeService;
  }

  @GetMapping
  public ResponseEntity<List<Employee>> getAllEmployees() {
    List<Employee> employees = employeeService.getAllEmployees();
    if(employees.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return ResponseEntity.ok(employees);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
    Employee employee = employeeService.getEmployeeById(id);
    if(employee.getId() == 0) {
      return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(employee);
  }

  @PostMapping
  public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
    employeeService.addEmployee(employee);
    return ResponseEntity.ok("Employee added successfully");
  }
}
