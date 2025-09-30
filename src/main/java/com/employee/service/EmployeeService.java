package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository; 
	
	public Employee addEmployee(Employee employee){ 
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployees() { 
		return employeeRepository.findAll(); 
	}
	
	public Employee getEmployeeById(Long id) { 
		return employeeRepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
	}
	
	public Employee updateEmployee(Long id, Employee updated) {
		Employee emp = getEmployeeById(id);
		emp.setName(updated.getName());
	    emp.setEmail(updated.getEmail()); 
	    emp.setDepartment(updated.getDepartment()); 
	    return employeeRepository.save(emp); 
	}
	
	public void deleteEmployee(Long id) { 
		employeeRepository.delete(getEmployeeById(id));
	}

}
