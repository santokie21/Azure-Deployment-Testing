package io.noobi.azure.service.impl;

import io.noobi.azure.model.Employee;
import io.noobi.azure.repository.EmployeeRepository;
import io.noobi.azure.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployeeById(Integer id){
    Employee dummy = new Employee(0,"none","Job-Less",0L);
    return employeeRepository.findById(id).orElse(dummy);
  }

  @Override
  public void addEmployee(Employee employee){
    employeeRepository.save(employee);
  }
}
