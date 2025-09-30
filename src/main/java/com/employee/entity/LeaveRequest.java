package com.employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LeaveRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne(optional = false) 
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@NotNull(message = "Start date is required") 
	private LocalDate startDate;
	
	@NotNull(message = "End date is required") 
	private LocalDate endDate; 
	
	private String reason;
	
	@Enumerated(EnumType.STRING) 
	private LeaveStatus status = LeaveStatus.PENDING;
	
	
	public enum LeaveStatus { 
		PENDING, APPROVED, REJECTED 
	}

}
