package com.chinasofti.bms.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.chinasofti.bms.dao.BookTypeDao;
import com.chinasofti.bms.dao.impl.BookTypeDaoImpl;
import com.chinasofti.bms.domain.BookType;

public class BookTypeTest {
	private BookType bookType = new BookType();
	private BookTypeDao bookTypeDao = new BookTypeDaoImpl();
	@Test
	public void test() throws SQLException{
		List<BookType> allBookType = bookTypeDao.getAllBookType();
		System.out.println(allBookType);
		bookType.setTypename("计算机");
		bookTypeDao.insertBookType(bookType);
		/*bookType.setTypename("会计");
		bookType.setBtid(3);
		bookTypeDao.updateBookType(bookType);*/
		bookTypeDao.deleteBookTypeById(4);
	}
}
