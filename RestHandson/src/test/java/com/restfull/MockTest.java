package com.restfull;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import com.restfull.controller.CountryController;


@SpringBootTest
@AutoConfigureMockMvc
class MockTest {
	@Autowired
	private CountryController controller;
	
	@Autowired
	private MockMvc mvc; 
	
	@Test
	public void contextLoad()
	{
		Assertions.assertNotNull(controller);
	}
	
	@Test
	public void testGetCountry() throws Exception
	{
		ResultActions action = mvc.perform(get("/country"));
		action.andExpect(status().isOk());
		action.andExpect(jsonPath("$.code").exists());
		action.andExpect(jsonPath("$.code").value("IN"));
	}
	
	@Test
	public void testGetCountryException() throws Exception
	{
		ResultActions action = mvc.perform(get("/country/ok"));
		action.andExpect(status().isNotFound());
		action.andExpect(status().reason("Country not found"));
		
	}
	
}