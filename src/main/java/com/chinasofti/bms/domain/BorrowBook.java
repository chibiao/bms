package com.chinasofti.bms.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 
 * @author 迟彪
 *		图书借阅信息
 */
public class BorrowBook implements Serializable{
	private Integer rid;// 读者编号
	private Integer bid;// 图书编号
	private Date borrowdate;// 借阅日期
	private Date returndate;// 归还日期
	private Double money;// 罚金
}
