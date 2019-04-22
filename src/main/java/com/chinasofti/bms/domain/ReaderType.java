package com.chinasofti.bms.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 
 * @author 迟彪
 *		读者类型
 */
public class ReaderType implements Serializable{
	private Integer tid; // 读者类型编号
	private String typename; // 读者类型名称
	private Integer maxborrownum;// 最大借阅量
	private Integer limitday;// 最大借阅天数
}
