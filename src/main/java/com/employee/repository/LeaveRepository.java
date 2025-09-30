package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.LeaveRequest;
@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Long>{
	List<LeaveRequest> findByEmployeeId(Long employeeId);
}
