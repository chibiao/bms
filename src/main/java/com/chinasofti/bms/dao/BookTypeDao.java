package com.chinasofti.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.bms.domain.BookType;

public interface BookTypeDao {
	/**
	 * 获取全部图书类型信息
	 * @return
	 * @throws SQLException
	 */
	List<BookType> getAllBookType()throws SQLException;
	/**
	 * 更新图书类型信息
	 * @param bookType
	 * @throws SQLException
	 */
	void updateBookType(BookType bookType)throws SQLException;
	/**
	 * 删除图书类型信息
	 * @param btid
	 * @throws SQLException
	 */
	void deleteBookTypeById(int btid)throws SQLException;
	/**
	 * 添加图书类型
	 * @param bookType
	 * @throws SQLException
	 */
	void insertBookType(BookType bookType)throws SQLException;
}
