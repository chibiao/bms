package com.chinasofti.bms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.bms.dao.BorrowBookDao;
import com.chinasofti.bms.domain.BorrowBook;
import com.chinasofti.bms.utils.JDBCUtil;

public class BorrowBookDaoImpl implements BorrowBookDao {
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

	public void insertBorrowBook(BorrowBook borrowBook) throws SQLException {
		String sql = "insert into borrowbook(rid,bid,borrowdate) values(?,?,?)";
		qr.update(sql, borrowBook.getRid(), borrowBook.getBid(),
				borrowBook.getBorrowdate());

	}

	public void updateBorrowBook(BorrowBook borrwoBook) throws SQLException {
		String sql = "update borrowbook set borrowdate=?,returndate=?,money=? where rid=? and bid=?";
		qr.update(sql, borrwoBook.getBorrowdate(), borrwoBook.getReturndate(),
				borrwoBook.getMoney(), borrwoBook.getRid(), borrwoBook.getBid());
	}

	public List<BorrowBook> getAllBorrowBooks() throws SQLException {
		String sql="select * from borrowbook";
		return qr.query(sql, new BeanListHandler<BorrowBook>(BorrowBook.class));
	}

	public List<BorrowBook> getBorrowBooksByReaderId(int readerId)
			throws SQLException {
		String sql="select * from borrowbook where rid=?";
		return qr.query(sql, new BeanListHandler<BorrowBook>(BorrowBook.class),readerId);
	}

	public List<BorrowBook> getBorrowBooksByBookId(int bookId)
			throws SQLException {
		String sql="select * from borrowbook where bid=?";
		return qr.query(sql, new BeanListHandler<BorrowBook>(BorrowBook.class),bookId);
	}

	public BorrowBook getBorrowBooksByRidAndBid(int rid, int bid) throws SQLException {
		String sql="select * from borrowbook where rid=? and bid=?";
		return qr.query(sql, new BeanHandler<BorrowBook>(BorrowBook.class),rid,bid);
	}

}
