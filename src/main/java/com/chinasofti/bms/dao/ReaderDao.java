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
	/**
	 * 获取所有读者信息
	 * @return
	 * @throws SQLException
	 */
	List<Reader> getAllReader()throws SQLException;
	/**
	 * 删除读者信息
	 * @param id
	 * @throws SQLException
	 */
	void deleteReaderById(int id)throws SQLException;
	/**
	 * 修改读者信息
	 * @param reader
	 * @throws SQLException
	 */
	void updateReader(Reader reader)throws SQLException;
	/**
	 * 添加读者信息
	 * @param reader
	 * @throws SQLException
	 */
	void insertReader(Reader reader)throws SQLException;
	/**
	 * 根据读者编号查询读者
	 * @param id 读者编号
	 * @return
	 * @throws SQLException
	 */
	Reader getReaderById(int id)throws SQLException;
	/**
	 * 查询最后插入的读者
	 * @return
	 * @throws SQLException
	 */
	Reader getLastReader()throws SQLException;
	/** 
	 *  查询最后count的读者
	 * @param count 数量
	 * @return
	 */
	List<Reader> getLastReader(int count)throws SQLException;
}
