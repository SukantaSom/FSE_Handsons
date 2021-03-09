package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication3 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication3.class);

	private static CountryService countryService;

	private static void testAddCountry() {

		Country country=new Country();
		country.setCode("JA");
		country.setName("Japan");
		
		countryService.addCountry(country);
		country=null;
		LOGGER.info("Start");
		try {
			country = countryService.findCountryByCode("JA");
		} catch (CountryNotFoundException e) {
			LOGGER.info(e.getMessage()+"JA");
		}
		LOGGER.debug("countries={}", country);
		LOGGER.info("End");

	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication3.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testAddCountry();
	}

}
