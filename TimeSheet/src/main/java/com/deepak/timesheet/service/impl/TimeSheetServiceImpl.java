package com.deepak.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.dao.TimeSheetDAOImpl;
import com.deepak.timesheet.model.Project;
import com.deepak.timesheet.model.Task;
import com.deepak.timesheet.service.TimeSheetService;

@Service
@Transactional
public class TimeSheetServiceImpl implements TimeSheetService {
	@Autowired
	TimeSheetDAOImpl timeSheetDAO;
	@Override
	public List<Project> findBySSOID(String ssoId) {
		return timeSheetDAO.findBySSOID(ssoId);
	}
	public List<Task> findByPID(String ssoId,int pid){
		return timeSheetDAO.findByPID(ssoId,pid);
		
	}

}
