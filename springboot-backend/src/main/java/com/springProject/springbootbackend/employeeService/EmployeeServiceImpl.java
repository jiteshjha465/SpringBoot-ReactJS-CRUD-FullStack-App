package com.springProject.springbootbackend.employeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springProject.springbootbackend.exception.ResourceNotFoundException;
import com.springProject.springbootbackend.exception.TechException;
import com.springProject.springbootbackend.model.Employee;
import com.springProject.springbootbackend.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() throws TechException {
		List<Employee> employees = employeeRepository.findAll();
		if (employees.isEmpty()) {
			throw new ResourceNotFoundException("Employees list is empty");
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee updateEmployee(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		employee.setName(employeeDetails.getName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setPhone(employeeDetails.getPhone());

		Employee updatedEmployee = employeeRepository.save(employee);

		return updatedEmployee;
	}
}
