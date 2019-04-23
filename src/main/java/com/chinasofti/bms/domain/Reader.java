package com.chinasofti.bms.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 
 * @author 迟彪
 *		读者信息
 */
public class Reader implements Serializable{
	private Integer rid; // 读者编号
	private Integer tid; // 读者类型编号
	private String rname; // 读者姓名
	private Integer age; // 读者年龄
	private String sex; // 读者性别
	private String phone; // 读者电话
	private String dept; // 所在系部
	private String password; //读者密码
	private Double money; //读者卡上余额
	private ReaderType readType;	//读者类型
	private List<BorrowBook> borrowBook;	//读者借阅信息

}
