package com.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.LeaveRequest;
import com.employee.service.LeaveRequestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/leaves")
public class LeaveRequestController {
	private final LeaveRequestService service;
	@PostMapping 
	public ResponseEntity<LeaveRequest> createLeave(@RequestBody LeaveRequest leave) {
		return ResponseEntity.ok(service.createLeave(leave)); 
	}
	
	@GetMapping 
	public List<LeaveRequest> getAllLeaves() { 
		return service.getAllLeaves();
	} 
	
	@GetMapping("/{id}")
	public LeaveRequest getLeave(@PathVariable Long id) {
		return service.getLeaveById(id);
	}
	
	@GetMapping("/employee/{employeeId}")
	public List<LeaveRequest> getLeavesByEmployee(@PathVariable Long employeeId) {
		return service.getLeavesByEmployee(employeeId);
	}
	
	@PutMapping("/{id}/status")
	public LeaveRequest updateStatus(@PathVariable Long id, @RequestParam LeaveRequest.LeaveStatus status) {
		return service.updateLeaveStatus(id, status); 
	}

}
