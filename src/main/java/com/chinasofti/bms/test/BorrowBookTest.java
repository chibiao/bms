package com.chinasofti.bms.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.chinasofti.bms.dao.BorrowBookDao;
import com.chinasofti.bms.dao.impl.BorrowBookDaoImpl;
import com.chinasofti.bms.domain.BorrowBook;
import com.chinasofti.bms.utils.DateUtil;

public class BorrowBookTest {
	private BorrowBook borrowBook = new BorrowBook();
	private BorrowBookDao borrowBookDao = new BorrowBookDaoImpl();
	@Test
	public void test() throws SQLException{
		/*List<BorrowBook> allBorrowBooks = borrowBookDao.getAllBorrowBooks();
		System.out.println(allBorrowBooks);*/
		/*List<BorrowBook> borrowBooksByBookId = borrowBookDao.getBorrowBooksByBookId(1);
		System.out.println(borrowBooksByBookId);*/
		List<BorrowBook> borrowBooksByReaderId = borrowBookDao.getBorrowBooksByReaderId(1);
		System.out.println(borrowBooksByReaderId);
	}
	@Test
	public void test2() throws SQLException{
		/*borrowBook.setBid(1);
		borrowBook.setRid(2);
		borrowBook.setBorrowdate(DateUtil.getCurrentDate());
		borrowBookDao.insertBorrowBook(borrowBook);*/
		borrowBook.setBid(1);
		borrowBook.setRid(2);
		borrowBook.setBorrowdate(DateUtil.getCurrentDate());
		borrowBook.setReturndate(DateUtil.getCurrentDate());
		borrowBook.setMoney((double) 0);
		borrowBookDao.updateBorrowBook(borrowBook);
	}
}
