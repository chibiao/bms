package com.chinasofti.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.bms.domain.BookType;

public interface BookTypeDao {
	/*
	 * 获取全部图书类型信息
	 */
	List<BookType> getAllBookType()throws SQLException;
	/*
	 * 更新图书类型信息
	 */
	void updateBookType(BookType bookType)throws SQLException;
	/*
	 * 删除图书类型信息
	 */
	void deleteBookTypeById(int btid)throws SQLException;
	/*
	 * 添加图书类型
	 */
	void insertBookType(BookType bookType)throws SQLException;
}
