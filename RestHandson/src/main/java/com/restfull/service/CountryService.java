package com.restfull.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.restfull.Exception.CountryNotFoundException;
import com.restfull.dao.CountriesList;
import com.restfull.model.Country;


@Service
public class CountryService {

	private static Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	private static CountriesList countriesBean = context.getBean("countryList",CountriesList.class);
	private List<Country> countryList =  countriesBean.getList();
	public Country getCountry(String code)
	{
		LOGGER.info("Started Get Country");
		for(Country con : countryList)
		{
			if(con.getCode().equalsIgnoreCase(code))
					{
					LOGGER.debug("Country:{}",con);
					LOGGER.info("End");
					return con;
					}
		}
		throw new CountryNotFoundException();
	}
	
	
	public List<Country> getAllCountry()
	{
		return countryList;
	}
	
	public void addCountry(Country country)
	{
		LOGGER.info("Started");
		
		if(country!= null)
		{
			countryList.add(country);
		}
		LOGGER.info("End");
		
		
	}
	
}
