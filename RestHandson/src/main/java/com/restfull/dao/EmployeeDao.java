package com.restfull.dao;

import java.util.Iterator;
import java.util.List;

import com.restfull.model.Employee;

public class EmployeeDao {
	private static List<Employee> list;

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

	public EmployeeDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDao(List<Employee> list) {
		super();
		this.list = list;
	}
	
	public void UpdateEmployee(Employee employee)
	{
		for(Employee emp:list)
		{
			if(emp.getEmpId().equalsIgnoreCase(employee.getEmpId()))
			{
				emp.setPermanent(employee.getPermanent());
			}
		}
	}
	
	public void deleteEmployee(String id)
	{
		Iterator iterator = list.iterator();
		while(iterator.hasNext())
		{
			Employee emp = (Employee)iterator.next();
			if(emp.getEmpId().equalsIgnoreCase(id))
			{
				iterator.remove();
			}
		}
	}
}
