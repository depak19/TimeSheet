package com.deepak.timesheet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deepak.timesheet.model.Employee;
import com.deepak.timesheet.service.EmployeeService;

@Controller
public class AdminController {
	static final Logger logger = Logger.getLogger(AdminController.class);
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = { "/adminPage.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String adminPage() {
		return "secured/admin/adminPage";
	}

	@RequestMapping(value = { "/showAllEmployees.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView showAllEmployees(
			@RequestParam(value = "empid", required = false) String empid,
			@RequestParam(value = "empname", required = false) String empname,
			@RequestParam(value = "salary", required = false) String salary,
			@RequestParam(value = "phno", required = false) String phno,
			@RequestParam(value = "page", required = false) String page) {

		int pageInt = 1;
		int recordsPerPage = 20;
		if (page != null)
			pageInt = Integer.parseInt(page);
		ModelAndView model = new ModelAndView();
		int noOfRecords = employeeService.getAllEmployees(empid, empname,
				salary, phno, 0, 0).size();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		List<Employee> employeeList = employeeService.getAllEmployees(empid,
				empname, salary, phno, (pageInt - 1) * recordsPerPage,
				recordsPerPage);
		model.addObject("employeeList", employeeList);
		model.addObject("noOfPages", noOfPages);
		model.addObject("currentPage", pageInt);
		model.addObject("noOfRecords", noOfRecords);
		model.addObject("recordsPerPage", recordsPerPage);
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("secured/showAllEmployees");
		return model;
	}

}
