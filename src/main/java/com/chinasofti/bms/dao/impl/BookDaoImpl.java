package com.chinasofti.bms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.bms.dao.BookDao;
import com.chinasofti.bms.domain.Book;
import com.chinasofti.bms.domain.BookType;
import com.chinasofti.bms.utils.JDBCUtil;

public class BookDaoImpl implements BookDao {
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

	public List<Book> getAllbooks() throws SQLException {
		String sql = "select * from book";
		List<Book> books = qr.query(sql, new BeanListHandler<Book>(Book.class));
		for (Book book : books) {
			String sql2 = "select * from booktype where btid=?";
			book.setBookType(qr.query(sql2, new BeanHandler<BookType>(
					BookType.class), book.getBtid()));
		}
		return books;
	}

	public List<Book> getAllbooksByName() throws SQLException {
		String sql = "select * from book where bname=?";
		return qr.query(sql, new BeanListHandler<Book>(Book.class));
	}

	public void updateBook(Book book) throws SQLException {
		String sql = "update book set btid=?,bname=?,author=?,publish=?,"
				+ "bnumber=?,price=? where bid=?";
		qr.update(sql, book.getBtid(), book.getBname(), book.getAuthor(),
				book.getPublish(), book.getBnumber(), book.getPrice(),
				book.getBid());
	}

	public void deleteBookById(Integer id) throws SQLException {
		String sql = "delete from book where bid=?";
		qr.update(sql, id);
	}

	public void insertBook(Book book) throws SQLException {
		String sql = "insert into book(btid,bname,author,publish,bnumber,price) values(?,?,?,?,?,?)";
		qr.update(sql, book.getBtid(), book.getBname(), book.getAuthor(),
				book.getPublish(), book.getBnumber(), book.getPrice());
	}

	public Book getBookById(Integer bid) throws SQLException {
		String sql = "select * from book where bid=?";
		Book book = qr.query(sql, new BeanHandler<Book>(Book.class), bid);
		if (book != null) {
			String sql2 = "select * from booktype where btid=?";
			book.setBookType(qr.query(sql2, new BeanHandler<BookType>(
					BookType.class), book.getBtid()));
		}
		return book;
	}

	public List<Book> getBooksByName(String bname) throws SQLException {
		String sql = "select * from book where bname like ?";
		List<Book> books = qr.query(sql, new BeanListHandler<Book>(Book.class),
				"%"+bname+"%");
		if (books != null) {
			for (Book book : books) {
				String sql2 = "select * from booktype where btid=?";
				book.setBookType(qr.query(sql2, new BeanHandler<BookType>(
						BookType.class), book.getBtid()));
			}
		}
		return books;
	}

	public Book getLastBook() throws SQLException {
		String sql = "select * from book where bid=((SELECT MAX(BID) FROM book))";
		Book book = qr.query(sql, new BeanHandler<Book>(Book.class));
		if(book!=null){
			String sql2 = "select * from booktype where btid=?";
			book.setBookType(qr.query(sql2, new BeanHandler<BookType>(
					BookType.class), book.getBtid()));
		}
		return book;
	}

}
