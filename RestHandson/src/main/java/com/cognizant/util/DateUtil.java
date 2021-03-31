package com.cognizant.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;

public class DateUtil {
	public static Date convertToDate(String date, ApplicationContext context) throws ParseException
	{
		DateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date d = format.parse(date);
		return d;
	}
}