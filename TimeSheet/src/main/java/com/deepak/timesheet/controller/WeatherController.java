package com.deepak.timesheet.controller;

import java.util.ArrayList;
import java.util.List;

import net.webservicex.globalweather.core.CurrentWeather;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deepak.timesheet.model.CountryCity;
import com.deepak.timesheet.service.CityByCountryService;

@Controller
public class WeatherController {
	static final Logger logger = Logger.getLogger(WeatherController.class);
	@Autowired
	CityByCountryService cityByCountryService;

	@RequestMapping(value = { "/weather.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String userPage() {
		return "secured/climate/weather";
	}

	@RequestMapping({ "/showAllCountries.do" })
	public ModelAndView showAllCountries(
			@RequestParam(value = "countryName", required = false) String countryName,
			@RequestParam(value = "cityName", required = false) String cityName,
			@RequestParam(value = "page", required = false) String page) {

		int pageInt = 1;
		int recordsPerPage = 100;
		int noOfRecords = 0;
		if (page != null)
			pageInt = Integer.parseInt(page);
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is User protected page!");
		List<CountryCity> cityList = new ArrayList<CountryCity>();
		noOfRecords = cityByCountryService.getAllCityByCountryName(countryName,
				cityName, 0, 0).size();
		cityList = cityByCountryService.getAllCityByCountryName(countryName,
				cityName, (pageInt - 1) * recordsPerPage, recordsPerPage);
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		model.addObject("cityList", cityList);
		model.addObject("noOfRecords", noOfRecords);
		model.addObject("recordsPerPage", recordsPerPage);
		model.addObject("noOfPages", noOfPages);
		model.addObject("currentPage", pageInt);
		model.setViewName("secured/climate/showAllCountries");
		return model;
	}

	@RequestMapping(value = { "/showWeatherDetails.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView showWeatherDetails(
			@RequestParam(value = "countryName", required = false) String countryName,
			@RequestParam(value = "cityName", required = false) String cityName) {

		ModelAndView model = new ModelAndView();
		CurrentWeather countryWeather = cityByCountryService.getCurrentWeather(
				countryName, cityName);
		model.addObject("weather", countryWeather);
		model.setViewName("secured/climate/showWeatherDetails");
		return model;
	}
}
