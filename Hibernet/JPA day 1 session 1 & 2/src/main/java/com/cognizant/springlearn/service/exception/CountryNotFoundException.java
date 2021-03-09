package com.cognizant.springlearn.service.exception;

public class CountryNotFoundException extends Exception {
	public CountryNotFoundException(String message) {
		super(message);
	}
}