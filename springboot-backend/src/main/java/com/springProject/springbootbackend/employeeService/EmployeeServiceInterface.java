package com.springProject.springbootbackend.employeeService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springProject.springbootbackend.exception.TechException;
import com.springProject.springbootbackend.model.Employee;

@Service
public interface EmployeeServiceInterface {

	public List<Employee> getAllEmployees() throws TechException;

	public Employee getEmployeeById(Long id);

	public Employee save(Employee employee);

	public Employee updateEmployee(Long id, Employee employeeDetails);

	public void deleteEmployee(Long id);
}
