package com.qsqs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CastStringToDate {

	public static long castStringToDate(String dateString) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
		date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date.getTime();
	}
}
