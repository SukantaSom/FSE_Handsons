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
public class OrmLearnApplication4 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication4.class);

	private static CountryService countryService;

	private static void testUpdateCountry() {

		Country country=null;
		
		LOGGER.info("Start");
		try {
			countryService.updateCountry("JA", "Japan");
			
			country = countryService.findCountryByCode("JA");
		} catch (CountryNotFoundException e) {
			LOGGER.info(e.getMessage()+"JA");
		}
		LOGGER.debug("countries={}", country);
		LOGGER.info("End");

	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication4.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testUpdateCountry();
	}

}
