package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;
		try {
			d = format.parse(date);
		}catch(ParseException e) {
			System.out.println(e);
		}
		
		return d;
	}
	
}
