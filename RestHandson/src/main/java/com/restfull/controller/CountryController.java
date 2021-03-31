package com.restfull.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.Exception.CountryNotFoundException;
import com.restfull.model.Country;
import com.restfull.service.CountryService;

@RestController
public class CountryController {
	private static Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	@Autowired
	private CountryService service= new CountryService();
	
	
	@GetMapping(path="/hello")
	public String sayHello()
	{
		LOGGER.info("Started");
		return "Hello World!!";
		
	}
	@GetMapping(path="/country")
	public Country getIndia()
	{

		for(Country con : service.getAllCountry())
		{
			if(con.getCode().equalsIgnoreCase("in"))
			{
				
				return con;
			}
		}
		
		throw new CountryNotFoundException();
		
	}
	
	@GetMapping(path="/country/{code}")
	public Country getCountry(@PathVariable String code)
	{
		LOGGER.info("Started");
		Country country =  service.getCountry(code);
		return country;
		
	}
	
	
	@GetMapping(path="/countries")
	public List<Country> getCountries()
	{
		LOGGER.info("Started");
		List<Country> countries = service.getAllCountry();
		LOGGER.debug("Countries:{}",countries);
		LOGGER.info("End");
		return countries;
	}
	
	@PostMapping(path="/country")
	public void addCountry(@RequestBody @Valid Country country)
	{
		LOGGER.info("Starte");
		service.addCountry(country);
		LOGGER.debug("Country:{}",country);
		LOGGER.info("After Adding Country");
		LOGGER.debug("List:{}",service.getAllCountry());		
		LOGGER.info("End");
		
	}
}
