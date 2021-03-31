package com.restfull.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.restfull.dao.DepartmentDao;
import com.restfull.model.Department;


@Service
public class DepartmentService {
	
	public List<Department> getAllDepartment()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DepartmentDao depd = context.getBean("deptList", DepartmentDao.class);
		List<Department> list = depd.getList();
		return list;
	}

}
