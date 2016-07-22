package com.deepak.timesheet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deepak.timesheet.model.Task;
import com.deepak.timesheet.service.TimeSheetService;

@Controller
public class TimeSheetController {
	static final Logger logger = Logger.getLogger(TimeSheetController.class);
	@Autowired
	TimeSheetService timeSheetService;
	
	@RequestMapping(value = { "/ote.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String welcomePage() {
		return "secured/timesheet/ote";
	}
	
	@RequestMapping(value = { "/showProjects.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView showProjects(
			@RequestParam(value = "empid", required = false) String ssoid) {

		ModelAndView model = new ModelAndView();
		model.addObject("projectList", timeSheetService.findBySSOID(ssoid));
		model.setViewName("secured/timesheet/showProjects");
		return model;
	}
	@RequestMapping(value = { "/showTasks.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView showTasks(
			@RequestParam(value = "empid", required = false) String ssoid,
			@RequestParam(value = "pid", required = false) String pid) {
		int pidInt = Integer.parseInt(pid);
		ModelAndView model = new ModelAndView();
		List<Task> taskList= timeSheetService.findByPID(ssoid,pidInt);
		logger.debug("No of Task ::"+taskList.size());
		model.addObject("taskList", taskList);
		model.setViewName("secured/timesheet/showTasks");
		return model;
	}
}
