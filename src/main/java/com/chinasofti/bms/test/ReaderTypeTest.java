package com.chinasofti.bms.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.chinasofti.bms.dao.ReaderTypeDao;
import com.chinasofti.bms.dao.impl.ReaderTypeDaoImpl;
import com.chinasofti.bms.domain.ReaderType;

public class ReaderTypeTest {
	private ReaderType readerType=new ReaderType();
	private ReaderTypeDao readerTypeDao=new ReaderTypeDaoImpl();
	@Test
	public void test() throws SQLException{
		List<ReaderType> allReadType = readerTypeDao.getAllReadType();
		for (ReaderType readerType : allReadType) {
			System.out.println(readerType);
		}
	}
	@Test
	public void test1()throws SQLException{
		readerType.setLimitday(10);
		readerType.setMaxborrownum(5);
		readerType.setTypename("教授");
		readerTypeDao.insertReadType(readerType);
	}
	@Test
	public void test2()throws SQLException{
		readerType.setLimitday(10);
		readerType.setMaxborrownum(3);
		readerType.setTypename("教授");
		readerType.setTid(3);
		readerTypeDao.updateReadType(readerType);
	}
	@Test
	public void test3() throws SQLException{
		readerTypeDao.deleteReadType(3);
	}
}
