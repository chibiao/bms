package com.chinasofti.bms.test;

import java.sql.Date;

import org.junit.Test;

import com.chinasofti.bms.utils.DateUtil;

public class DateUtilTest {
	@Test
	public void test(){
		Date currentDate = DateUtil.getCurrentDate();
		String str ="2019-4-25";
		Date endDate=Date.valueOf(str);
		java.util.Date d = currentDate;
		int days=DateUtil.getDay(currentDate, endDate);
		System.out.println(days);
	}
}
