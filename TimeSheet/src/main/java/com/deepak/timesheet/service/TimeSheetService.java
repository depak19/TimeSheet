package com.deepak.timesheet.service;

import java.util.List;

import com.deepak.timesheet.model.Project;
import com.deepak.timesheet.model.Task;

public interface TimeSheetService {
	public List<Project> findBySSOID(String ssoId);
	public List<Task> findByPID(String ssoId,int pid);
}
