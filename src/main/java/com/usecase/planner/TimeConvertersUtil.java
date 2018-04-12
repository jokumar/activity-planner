package com.usecase.planner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.usecase.planner.bean.Activity;
import com.usecase.planner.constant.ActivityConstant;
/**
 * 
 * @author jokumar
 * TimeConvertersUtil class to provide some of the utility classes 	
 */


public class TimeConvertersUtil {
	
	static  Logger logger = Logger.getLogger(TimeConvertersUtil.class);

	private static ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(ActivityConstant.HOUR_FORMAT);
		}
	};

	private static ThreadLocal<SimpleDateFormat> dfTwelve = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(ActivityConstant.HOUR_FORMAT_12);
		}
	};

	//Compare if sampleTime falls between start and end time
	public static Boolean  inBetweenTime(String sampleTime, String startTime, String endTime) {
		Date date1 = null;
		Date date2 = null;
		Date sampleDate = null;
		try {
			date1 = df.get().parse(startTime);
			date2 = df.get().parse(endTime);
			sampleDate = df.get().parse(sampleTime);
		} catch (ParseException e) {
			logger.error("Parsing Error ",e);
		}
		return sampleDate != null && sampleDate.after(date1) && sampleDate.before(date2);
	}

	//compare if time1 falls after time2
	public static Boolean compareTime(String time1, String time2) {
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = df.get().parse(time1);
			date2 = df.get().parse(time2);
		} catch (ParseException e) {
			logger.error("Parsing Error ",e);
		}
		return date1 != null && date1.after(date2);
	}

	//add minutes to a time
	public static String addTime(String time, int minutes) {
		Calendar cal = Calendar.getInstance();
		Date date;
		try {
			date = df.get().parse(time);
			cal.setTime(date);
			cal.add(Calendar.MINUTE, minutes);
		} catch (ParseException e) {
			logger.error("Parsing Error ",e);
		}
		return df.get().format(cal.getTime());
	}

	//convert 24 hrs to 12 hours format
	public static String convert24HrsTo12Hrs(String time) {
		Date date = null;
		try {
			date = df.get().parse(time);

		} catch (ParseException e) {
			logger.error("Parsing Error ",e);
		}
		return dfTwelve.get().format(date);
	}

}
