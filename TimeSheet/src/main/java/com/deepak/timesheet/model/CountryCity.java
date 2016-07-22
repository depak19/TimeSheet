package com.deepak.timesheet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRYCITY")
public class CountryCity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
		 * 
		 */
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	@Column(name = "CITY_NAME")
	private String cityName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
