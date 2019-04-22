package com.chinasofti.bms.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.chinasofti.bms.dao.impl.UserDaoImpl;
import com.chinasofti.bms.domain.User;

public class UserTest {
	private User user = new User();
	private UserDaoImpl userService = new UserDaoImpl();
	@Test
	public void test() throws SQLException{
		userService.deleteUserById(1);
	}
	@Test
	public void test2() throws SQLException{
		List<User> user2 = userService.getAllUser();
		for (User user : user2) {
			System.out.println(user);
		}
	}
	@Test
	public void test3()throws SQLException{
		user.setMid(1);
		user.setUname("迟彪");
		user.setPassword("123456");
		userService.updateUser(user);
	}
	@Test
	public void test4()throws SQLException{
		user.setUname("迟彪");
		user.setPassword("123456");
		userService.insertUser(user);
	}
}
