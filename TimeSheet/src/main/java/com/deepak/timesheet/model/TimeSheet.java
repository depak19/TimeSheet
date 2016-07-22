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
@Table(name = "TIME_SHEET")
public class TimeSheet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6711922156964101594L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "N_TS_ID")
	private int tsId;
	@Column(name = "V_SSO_ID")
	private String ssoId;
	@Column(name = "N_PID")
	private int pId;
	@Column(name = "N_TK_ID")
	private int tkId;
	@Column(name = "D_WEEK_START_DATE") 
	private Date weekStartDate;
	@Column(name = "D_WEEK_END_DATE") 
	private Date weekEndDate;
	@Column(name = "N_SUN_DAY")
	private int sunDay;
	@Column(name = "N_MON_DAY")
	private int monDay;
	@Column(name = "N_TUE_DAY")
	private int tueDay;
	@Column(name = "N_WED_DAY")
	private int wedDay;
	@Column(name = "N_THU_DAY")
	private int thuDay;
	@Column(name = "N_FRI_DAY")
	private int friDay;
	@Column(name = "N_SAT_DAY")
	private int satDay;
	
	public int getTsId() {
		return tsId;
	}
	public void setTsId(int tsId) {
		this.tsId = tsId;
	}
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
	public int getTkId() {
		return tkId;
	}
	public void setTkId(int tkId) {
		this.tkId = tkId;
	}
	public Date getWeekStartDate() {
		return weekStartDate;
	}
	public void setWeekStartDate(Date weekStartDate) {
		this.weekStartDate = weekStartDate;
	}
	public Date getWeekEndDate() {
		return weekEndDate;
	}
	public void setWeekEndDate(Date weekEndDate) {
		this.weekEndDate = weekEndDate;
	}
	public int getSunDay() {
		return sunDay;
	}
	public void setSunDay(int sunDay) {
		this.sunDay = sunDay;
	}
	public int getMonDay() {
		return monDay;
	}
	public void setMonDay(int monDay) {
		this.monDay = monDay;
	}
	public int getTueDay() {
		return tueDay;
	}
	public void setTueDay(int tueDay) {
		this.tueDay = tueDay;
	}
	public int getWedDay() {
		return wedDay;
	}
	public void setWedDay(int wedDay) {
		this.wedDay = wedDay;
	}
	public int getThuDay() {
		return thuDay;
	}
	public void setThuDay(int thuDay) {
		this.thuDay = thuDay;
	}
	public int getFriDay() {
		return friDay;
	}
	public void setFriDay(int friDay) {
		this.friDay = friDay;
	}
	public int getSatDay() {
		return satDay;
	}
	public void setSatDay(int satDay) {
		this.satDay = satDay;
	}
}
