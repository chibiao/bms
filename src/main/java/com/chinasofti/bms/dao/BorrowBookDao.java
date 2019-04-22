package com.chinasofti.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.bms.domain.BorrowBook;

public interface BorrowBookDao {
	/**
	 * 添加借阅信息
	 * @param borrowBook
	 */
	void insertBorrowBook(BorrowBook borrowBook)throws SQLException;
	/**
	 * 更新借阅信息
	 * @param borrwoBook
	 */
	void updateBorrowBook(BorrowBook borrwoBook)throws SQLException;
	//查询所有借阅信息
	/**
	 * 查询所有借阅信息
	 * @return
	 */
	List<BorrowBook> getAllBorrowBooks()throws SQLException;
	/**
	 * 根据读者id查询借阅信息
	 * @param id
	 * @return
	 */
	List<BorrowBook> getBorrowBooksByReaderId(int readerId)throws SQLException;
	/**
	 * 根据图书id查询借阅信息
	 * @param bookId
	 * @return
	 */
	List<BorrowBook> getBorrowBooksByBookId(int bookId)throws SQLException;
	/**
	 * 根据图书id和读者id查询借阅信息
	 * @param rid
	 * @param bid
	 * @return
	 */
	BorrowBook getBorrowBooksByRidAndBid(int rid,int bid)throws SQLException;
}
