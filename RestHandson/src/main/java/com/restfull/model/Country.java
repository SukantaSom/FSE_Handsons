package com.restfull.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Country {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	@NotNull
	@Size(min=2,max=2,message="Code Should be of 2 Digit")
	private String code;
	private String name;

	public String getCode() {
		LOGGER.debug("Inside code getter");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside code setter");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside name getter");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside name setter");
		this.name = name;
	}
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public Country() {
		super();
		LOGGER.debug("Inside Country Constructor");
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	

}
