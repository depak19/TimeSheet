package com.deepak.timesheet.service;

import java.util.List;

import com.deepak.timesheet.model.CountryCity;

import net.webservicex.globalweather.core.CurrentWeather;
import net.webservicex.globalweather.core.Table;

public abstract interface CityByCountryService {
	public List<CountryCity> getAllCityByCountryName(String countryName,
			String cityName, int offset, int noOfRecords);

	public List<Table> getCityByCountryName();

	public CurrentWeather getCurrentWeather(String countryName, String cityName);
}
