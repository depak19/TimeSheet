package com.deepak.timesheet.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ProjectMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3077675911452913912L;
	@Column(name = "V_SSO_ID")
	private String ssoId;
	@Column(name = "N_PID")
	private int pId;
	public String getSsoId() {
		return ssoId;
	}
	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROJECT_DETAILS", joinColumns = { @JoinColumn(name = "N_PID") }, inverseJoinColumns = { @JoinColumn(name = "N_PID") })
	private Set<Project> project = new HashSet<Project>();
	
	public Set<Project> getProject() {
		return project;
	}

	public void setProject(Set<Project> project) {
		this.project = project;
	}*/
	
}
