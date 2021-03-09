package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication2.class);

	private static CountryService countryService;

	private static void getAllCountriesTest() {

		LOGGER.info("Start");
		Country country=null;
		try {
			country = countryService.findCountryByCode("INR");
		} catch (CountryNotFoundException e) {
			LOGGER.info(e.getMessage()+"INR");
		}
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");

	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication2.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		getAllCountriesTest();
	}

}
