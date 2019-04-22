package com.chinasofti.bms.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.chinasofti.bms.dao.ReaderDao;
import com.chinasofti.bms.dao.impl.ReaderDaoImpl;
import com.chinasofti.bms.domain.Reader;

public class ReaderTest {
	private Reader reader = new Reader();
	private ReaderDao readerDao = new ReaderDaoImpl();
	@Test
	public void test() {
		try {
			reader = readerDao.getReader(1, "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(reader);
	}
	@Test
	public void test2() throws SQLException{
		List<Reader> allReader = readerDao.getAllReader();
		for (Reader reader : allReader) {
			System.out.println(reader);
		}
	}
	@Test
	public void test3() throws SQLException{
		reader.setAge(20);
		reader.setDept("会计系");
		reader.setPassword("123456");
		reader.setPhone("15511786182");
		reader.setRname("李志远");
		reader.setSex("男");
		reader.setTid(1);
		readerDao.insertReader(reader);
	}
	@Test
	public void test4() throws SQLException{
		reader.setAge(20);
		reader.setDept("会计系");
		reader.setPassword("1234567");
		reader.setPhone("15511786182");
		reader.setRname("李志远");
		reader.setSex("男");
		reader.setTid(1);
		reader.setRid(3);
		readerDao.updateReader(reader);
	}
	@Test
	public void test5(){
		try {
			readerDao.deleteReaderById(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
