package com.chinasofti.bms.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
/**
 * 
 * @author 迟彪
 *		管理员信息
 */
public class User implements Serializable{
	private Integer mid;// 用户编号
	private String uname;// 用户姓名
	private String password;// 用户密码
}
