package com.sc.framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * @author cuibin
 */
public final class DateConvertUtils {
	/**
	 * <>
	 */
	private DateConvertUtils() {
	}

	/**
	 * 
	 * @param dateString
	 *            dateString
	 * @param dateFormat
	 *            dateFormat
	 * @return date
	 */
	public static java.util.Date parse(String dateString, String dateFormat) {
		return parse(dateString, dateFormat, java.util.Date.class);
	}

	/**
	 * 
	 * @param <T>
	 *            <T>
	 * @param dateString
	 *            dateString
	 * @param dateFormat
	 *            dateFormat
	 * @param targetResultType
	 *            targetResultType
	 * @return <T>
	 */
	public static <T extends java.util.Date> T parse(String dateString,
			String dateFormat, Class<T> targetResultType) {
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			long time = df.parse(dateString).getTime();
			java.util.Date t = targetResultType.getConstructor(long.class)
					.newInstance(time);
			return (T) t;
		} catch (ParseException e) {
			String errorInfo = "cannot use dateformat:" + dateFormat
					+ " parse datestring:" + dateString;
			throw new IllegalArgumentException(errorInfo, e);
		} catch (Exception e) {
			throw new IllegalArgumentException("error targetResultType:"
					+ targetResultType.getName(), e);
		}
	}

	/**
	 * 
	 * @param date
	 *            date
	 * @param dateFormat
	 *            dateFormat
	 * @return string
	 */
	public static String format(java.util.Date date, String dateFormat) {
		if (null == date) {
			return null;
		}
		return new SimpleDateFormat(dateFormat).format(date);
	}

	/**
	 * 
	 * @param date
	 *            date
	 * @param dateFormat
	 *            dateFormat
	 * @return string
	 */
	public static Date formatDate(java.util.Date date, String dateFormat) {
		if (null == date) {
			return null;
		}
		return parse(new SimpleDateFormat(dateFormat).format(date), dateFormat);
	}

	/**
	 * 时间差
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return
	 */
	public static long getMinSub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd hh:mm");
		java.util.Date beginDate;
		java.util.Date endDate;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
			day = (endDate.getTime() - beginDate.getTime()) / ( 60 * 1000);
			// System.out.println("相隔的天数="+day);
		} catch (ParseException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return day;
	}
	
	public static long getMinSub(String dateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd hh:mm");
		java.util.Date beginDate;
		java.util.Date endDate;
		try {
			beginDate = format.parse(dateStr);
			endDate = new Date();
			day = (endDate.getTime() - beginDate.getTime()) / ( 60 * 1000);
			// System.out.println("相隔的天数="+day);
		} catch (ParseException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return day;
	}
}
