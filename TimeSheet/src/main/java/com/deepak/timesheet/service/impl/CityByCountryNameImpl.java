package com.deepak.timesheet.service.impl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.webservicex.globalweather.GlobalWeather;
import net.webservicex.globalweather.GlobalWeatherSoap;
import net.webservicex.globalweather.core.CurrentWeather;
import net.webservicex.globalweather.core.NewDataSet;
import net.webservicex.globalweather.core.Table;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.appl.ApplicationConstants;
import com.deepak.timesheet.dao.CountryCityDAOImpl;
import com.deepak.timesheet.model.CountryCity;
import com.deepak.timesheet.service.CityByCountryName;

@Service
@Transactional
public class CityByCountryNameImpl implements CityByCountryName {

	static final Logger logger = Logger.getLogger(CityByCountryNameImpl.class);
	@Autowired
	CountryCityDAOImpl countryCityDAO;

	@Cacheable(value = "getCityByCountryName", key = "#getCityByCountryName")
	@Override
	@Transactional
	public List<CountryCity> getAllCityByCountryName(String countryName,
			String cityName, int offset, int noOfRecords) {
		List<CountryCity> cityList = new ArrayList<CountryCity>();
		int noOfrecords = countryCityDAO.getAllCountryCity(countryName,
				cityName, offset, noOfRecords).size();
		if (noOfrecords > 0) {
			cityList = countryCityDAO.getAllCountryCity(countryName, cityName,
					offset, noOfRecords);
		} else {
			cityList = countryCityDAO
					.insertAllCountryCity(getCityByCountryName(countryName));
		}
		return cityList;
	}

	@Override
	public List<Table> getCityByCountryName(String countryName) {
		List<Table> table = new ArrayList<Table>();
		try {
			GlobalWeather globalWeather = new GlobalWeather();
			GlobalWeatherSoap globalWeatherSoap = globalWeather
					.getGlobalWeatherSoap();
			String Cities = globalWeatherSoap.getCitiesByCountry(countryName);
			StringReader reader = new StringReader(Cities);
			JAXBContext jaxbContext = JAXBContext
					.newInstance(new Class[] { NewDataSet.class });
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			NewDataSet newDataSet = (NewDataSet) jaxbUnmarshaller
					.unmarshal(reader);
			table = newDataSet.getTable();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return table;
	}

	@Override
	public CurrentWeather getCurrentWeather(String countryName, String cityName) {
		CurrentWeather currentWeather = new CurrentWeather();
		try {
			GlobalWeather globalWeather = new GlobalWeather();
			GlobalWeatherSoap globalWeatherSoap = globalWeather
					.getGlobalWeatherSoap();
			String weatherString = globalWeatherSoap.getWeather(cityName,
					countryName);
			if (!weatherString.equals(ApplicationConstants.DATA_NOT_FOUND)) {
				StringReader reader = new StringReader(weatherString);
				JAXBContext jaxbContext = JAXBContext
						.newInstance(new Class[] { CurrentWeather.class });
				Unmarshaller jaxbUnmarshaller = jaxbContext
						.createUnmarshaller();
				currentWeather = (CurrentWeather) jaxbUnmarshaller
						.unmarshal(reader);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return currentWeather;
	}
}
