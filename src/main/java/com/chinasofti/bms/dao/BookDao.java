package com.chinasofti.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.bms.domain.Book;

public interface BookDao {
	/*
	 * 查询所有图书
	 */
	public List<Book> getAllbooks() throws SQLException;
	/*
	 * 根据图书名称查询图书
	 */
	public List<Book> getAllbooksByName() throws SQLException;
	/*
	 * 修改图书信息
	 */
	public void updateBook(Book book) throws SQLException;
	/*
	 * 删除图书信息
	 */
	public void deleteBookById(Integer id) throws SQLException;
	/*
	 * 添加图书信息
	 */
	public void insertBook(Book book) throws SQLException;
	/*
	 * 通过编号查询图书
	 */
	public Book getBookById(Integer bid) throws SQLException;
	/*
	 * 通过图书名称查询图书
	 */
	public List<Book> getBooksByName(String bname)throws SQLException;
	/**
	 * 获取最后一本添加的图书
	 * @return
	 * @throws SQLException
	 */
	public Book getLastBook()throws SQLException;
	
}
