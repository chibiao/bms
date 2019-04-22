package com.chinasofti.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.bms.domain.User;

public interface UserDao {
	//查询用户
	List<User> getAllUser()throws SQLException;
	//修改用户
	void updateUser(User user)throws SQLException;
	//根据id删除用户
	void deleteUserById(int id)throws SQLException;
	//添加用户
	void insertUser(User user)throws SQLException;
	//根据id查询
	User getUser(int id,String pwd)throws SQLException;
	User getUserById(int id)throws SQLException;
}
