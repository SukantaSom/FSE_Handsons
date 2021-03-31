package com.restfull.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.restfull.dao.EmployeeDao;
import com.restfull.model.Employee;


@Service
public class EmployeeService {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
	private static EmployeeDao empd = context.getBean("employeeList",EmployeeDao.class);
	
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> list = empd.getList();
		return list;
	}
	
	public void updateEmployee(Employee employee)
	{
		empd.UpdateEmployee(employee);
	}
	
	public void deleteEmployee(String id)
	{
		empd.deleteEmployee(id);
	}

}
