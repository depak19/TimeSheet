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
@Table(name = "PROJECT_DETAILS")
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1334034883337580088L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "N_PID")
	private int pId;
	
	@Column(name = "V_PROJECT_NAME") 
	private String projectName;
	@Column(name = "N_APPROVER_ID") 
	private int approverId;
	@Column(name = "D_START_DATE") 
	private Date startDate;
	@Column(name = "D_END_DATE") 
	private Date endDate;
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getApproverId() {
		return approverId;
	}
	public void setApproverId(int approverId) {
		this.approverId = approverId;
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
	
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TASK_DETAILS", joinColumns = { @JoinColumn(name = "N_PID") }, inverseJoinColumns = { @JoinColumn(name = "N_PID") })
	private Set<Task> task = new HashSet<Task>();
	
	public Set<Task> getTask() {
		return task;
	}

	public void setTask(Set<Task> task) {
		this.task = task;
	}*/

}
