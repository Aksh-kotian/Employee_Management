package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.LeaveRequest;
import com.employee.exception.ResourceNotFoundException;
import com.employee.repository.LeaveRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {
	
	private final LeaveRepository leaveRepo;
	
	public LeaveRequest createLeave(LeaveRequest leave){ 
		if (leave.getEndDate().isBefore(leave.getStartDate())) { 
		throw new IllegalArgumentException("End date must be after start date"); 
		} 
		return leaveRepo.save(leave);
		} 
	
	public List<LeaveRequest> getAllLeaves() {
		return leaveRepo.findAll();
		}
	
	public LeaveRequest getLeaveById(Long id) {
		return leaveRepo.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Leave not found with id " + id));
		}
	
	public List<LeaveRequest> getLeavesByEmployee(Long employeeId) { 
		return leaveRepo.findByEmployeeId(employeeId);
		}
	
	public LeaveRequest updateLeaveStatus(Long id, LeaveRequest.LeaveStatus status) {
		LeaveRequest leave = getLeaveById(id); leave.setStatus(status);
		return leaveRepo.save(leave);
		
	}

}
