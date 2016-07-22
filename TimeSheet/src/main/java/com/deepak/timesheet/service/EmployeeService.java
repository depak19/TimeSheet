package com.deepak.timesheet.service;

import com.deepak.timesheet.model.Employee;

import java.util.List;

public interface EmployeeService {
	public List<Employee> getAllEmployees(String empid, String empname,
			String salary, String phno, int offset, int noOfRecords);
}
