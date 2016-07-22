package com.deepak.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.dao.EmployeeDAOImpl;
import com.deepak.timesheet.model.Employee;
import com.deepak.timesheet.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAOImpl employeeDAO;

	@Transactional
	public List<Employee> getAllEmployees(String empid, String name,
			String salary, String phno, int offset, int noOfRecords) {
		return employeeDAO.listEmployee(empid, name, salary, phno, offset,
				noOfRecords);
	}

}
