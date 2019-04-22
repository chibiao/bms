package com.chinasofti.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.bms.domain.Reader;

public interface ReaderDao {
	/**
	 * 
	 * @param rid
	 * @param password
	 * @return	Reader
	 * @throws SQLException
	 * 		根据id和密码查询读者
	 */
	Reader getReader(int rid,String password) throws SQLException;
	/*
	 * 获取所有读者信息
	 */
	List<Reader> getAllReader()throws SQLException;
	/*
	 * 删除读者信息
	 */
	void deleteReaderById(int id)throws SQLException;
	/*
	 * 修改读者信息
	 */
	void updateReader(Reader reader)throws SQLException;
	/*
	 * 添加读者信息
	 */
	void insertReader(Reader reader)throws SQLException;
	Reader getReaderById(int id)throws SQLException;
}
