package com.restfull.dao;

import java.util.List;

import com.restfull.model.Country;

public class CountriesList {
	
	private List<Country> list;
	public CountriesList(List<Country> list) {
		super();
		this.list = list;
	}
	public List<Country> getList() {
		return list;
	}
	public void setList(List<Country> list) {
		this.list = list;
	}
	public CountriesList() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CountriesList [list=" + list + "]";
	}
	

}
