package com.chinasofti.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.bms.domain.User;

public interface UserDao {
	/**
	 * 查询用户
	 * @return
	 * @throws SQLException
	 */
	List<User> getAllUser()throws SQLException;
	/**
	 * 修改用户
	 * @param user
	 * @throws SQLException
	 */
	void updateUser(User user)throws SQLException;
	/**
	 * 根据id删除用户
	 * @param id
	 * @throws SQLException
	 */
	void deleteUserById(int id)throws SQLException;
	/**
	 * 添加用户
	 * @param user
	 * @throws SQLException
	 */
	void insertUser(User user)throws SQLException;
	/**
	 * 根据id查询
	 * @param id
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	User getUser(int id,String pwd)throws SQLException;
	/**
	 * 根据管理员id查询管理员
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	User getUserById(int id)throws SQLException;
}
