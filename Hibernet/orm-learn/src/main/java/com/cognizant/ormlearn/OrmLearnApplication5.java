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
public class OrmLearnApplication5 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication5.class);

	private static CountryService countryService;

	private static void testDeleteCountry() {

		Country country=null;
		
		String code="JA";
		countryService.deleteCountry(code);
		
		LOGGER.info("Start");
		try {		
			country = countryService.findCountryByCode(code);
		} catch (CountryNotFoundException e) {
			LOGGER.info("The Country with code "+code+" has been sucessfully deleted");
		}
		LOGGER.debug("countries={}", country);
		LOGGER.info("End");

	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication5.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testDeleteCountry();
	}

}
