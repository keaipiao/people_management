package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//字符串转日期
	public static Date stringToDate(String dateStr) {
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	//日期转字符串
	public static String dateToString(Date date) {
		String dateStr = sdf.format(date);
		return dateStr;
	}
}
