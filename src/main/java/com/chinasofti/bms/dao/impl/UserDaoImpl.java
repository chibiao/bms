package com.chinasofti.bms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.bms.dao.UserDao;
import com.chinasofti.bms.domain.User;
import com.chinasofti.bms.utils.JDBCUtil;

public class UserDaoImpl implements UserDao{
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
	public List<User> getAllUser() throws SQLException {
		String sql = "select * from manager";
		return qr.query(sql, new BeanListHandler<User>(User.class));
	}

	public void updateUser(User user) throws SQLException {
		String sql="update manager set uname=?,password=? where mid=?";
		qr.update(sql, user.getUname(),user.getPassword(),user.getMid());
	}

	public void deleteUserById(int id) throws SQLException {
		String sql="delete from manager where mid=?";
		qr.update(sql,id);
	}

	public void insertUser(User user) throws SQLException {
		String sql="insert into manager(uname,password) values(?,?)";
		qr.update(sql,user.getUname(),user.getPassword());
	}

	public User getUser(int id, String pwd) throws SQLException {
		String sql="select * from manager where mid=? and password=?";
		return qr.query(sql, new BeanHandler<User>(User.class),id,pwd);
	}

	public User getUserById(int id) throws SQLException {
		String sql="select * from manager where mid=?";
		return qr.query(sql, new BeanHandler<User>(User.class),id);
	}
}
