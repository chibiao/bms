package com.chinasofti.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.bms.domain.ReaderType;

public interface ReaderTypeDao {
	/**
	 * 获取所有读者类型
	 * @return
	 * @throws SQLException
	 */
	List<ReaderType> getAllReadType()throws SQLException;
	/**
	 * 修改读者类型
	 * @param readType
	 * @throws SQLException
	 */
	void updateReadType(ReaderType readType)throws SQLException;
	/**
	 * 删除读者类型
	 * @param id
	 * @throws SQLException
	 */
	void deleteReadType(int id)throws SQLException;
	/**
	 *  添加读者类型
	 * @param readType
	 * @throws SQLException
	 */
	void insertReadType(ReaderType readType)throws SQLException;
}
