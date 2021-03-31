package com.restfull.dao;

import java.util.List;

import com.restfull.model.Department;

public class DepartmentDao {
	private List<Department> list;

	public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
		this.list = list;
	}

	public DepartmentDao(List<Department> list) {
		super();
		this.list = list;
	}

	public DepartmentDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
