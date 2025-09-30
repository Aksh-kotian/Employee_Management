package com.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService service;
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) { 
		return ResponseEntity.ok(service.addEmployee(employee));
		}
	
	@GetMapping 
	public List<Employee> getAll() { 
		return service.getAllEmployees(); 
	} 
	
	@GetMapping("/{id}") 
	public Employee getOne(@PathVariable Long id)
	{ 
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/{id}") 
	public Employee update(@PathVariable Long id, @RequestBody Employee emp){
		return service.updateEmployee(id, emp);

}
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteEmployee(id);
		return ResponseEntity.noContent().build(); 
	}
}
