package com.deepak.timesheet.dao;

import java.util.ArrayList;
import java.util.List;

import net.webservicex.globalweather.core.Table;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.model.CountryCity;
import com.deepak.timesheet.util.StringUtils;

@Repository("countryCityDAO")
@Transactional
public class CountryCityDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;
	static final Logger logger = Logger.getLogger(EmployeeDAOImpl.class);


	public List<CountryCity> insertAllCountryCity(List<Table> tableList) {
		List<CountryCity> cityList = new ArrayList<CountryCity>();
		CountryCity countryCity = new CountryCity();
		int id = 1;
		//String sbSql = "INSERT INTO COUNTRYCITY (ID,COUNTRY_NAME,CITY_NAME) VALUES (?,?,?)";
		for (Table city : tableList) {	
			countryCity.setId(id);
			countryCity.setCountryName(city.getCountry());
			countryCity.setCityName(city.getCity());
			sessionFactory.getCurrentSession().persist(countryCity);
			cityList.add(countryCity);
			id++;
		}
		return cityList;
	}

	public List<CountryCity> getAllCountryCity(String countryName,
			String cityName, int offset, int noOfRecords) {
		String sbSql = getFilter(countryName, cityName, offset, noOfRecords);
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sbSql);
		query.addEntity(CountryCity.class);
		@SuppressWarnings("unchecked")
		List<CountryCity> countryCityList =  query.list();
		return countryCityList;
	}

	protected String getFilter(String countryName, String cityName, int offset,
			int noOfRecords) {
		StringBuilder sbSql = new StringBuilder(
				"SELECT * FROM (SELECT C.*,ROWNUM RM FROM (SELECT C.* FROM COUNTRYCITY C WHERE 1=1 ORDER BY C.COUNTRY_NAME,C.CITY_NAME) C WHERE 1=1 ");
		if (noOfRecords > 0)
			sbSql.append(" AND ROWNUM <=" + (offset + noOfRecords));

		if (StringUtils.notNullOrBlank(countryName)) {
			sbSql.append(" AND UPPER(C.COUNTRY_NAME) LIKE UPPER('%"
					+ countryName + "%')");
		}
		if (StringUtils.notNullOrBlank(cityName)) {
			sbSql.append(" AND UPPER(C.CITY_NAME) LIKE UPPER('%" + cityName
					+ "%')");
		}
		sbSql.append(" ORDER BY C.COUNTRY_NAME,C.CITY_NAME) COUNTRYCITY");

		if (noOfRecords > 0)
			sbSql.append(" WHERE RM >=" + (offset + 1));
		else
			sbSql.append(" WHERE 1=1");
		return sbSql.toString();
	}
}
