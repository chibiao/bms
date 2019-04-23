package com.chinasofti.bms.utils;

import java.sql.Date;
import java.util.Calendar;
/**
 * 这是一个处理时间的工具类
 * @author 迟彪
 *
 */
public class DateUtil {
	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		int y, m, d;
		Calendar cal = Calendar.getInstance();
		y = cal.get(Calendar.YEAR);
		m = cal.get(Calendar.MONTH);
		d = cal.get(Calendar.DATE);
		String str = y + "-" + (m + 1) + "-" + d;
		Date date = Date.valueOf(str);
		return date;
	}

	/**
	 * 根据两个时间获取时间差
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDay(Date startDate, Date endDate) {
		java.util.Date d = startDate;
		java.util.Date d2 = endDate;
		int days = (int) ((d2.getTime() - d.getTime()) / (1000 * 3600 * 24));
		return days;
	}
}
