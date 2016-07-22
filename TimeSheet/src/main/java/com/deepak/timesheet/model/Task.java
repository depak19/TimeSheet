package com.deepak.timesheet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_DETAILS")
public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6447592764262762650L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "N_TK_ID")
	private int tkId;
	@Column(name = "V_TASK_NAME") 
	private String taskName;
	@Column(name = "D_START_DATE") 
	private Date startDate;
	@Column(name = "D_END_DATE") 
	private Date endDate;
	@Column(name = "N_PID")
	private int pId;
	
	private TimeSheet timeSheet;
	public int getTkId() {
		return tkId;
	}
	public void setTkId(int tkId) {
		this.tkId = tkId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public TimeSheet getTimeSheet() {
		return timeSheet;
	}
	public void setTimeSheet(TimeSheet timeSheet) {
		this.timeSheet = timeSheet;
	}
	
}
