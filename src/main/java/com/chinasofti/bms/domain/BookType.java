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
 *		图书类型信息
 */
public class BookType implements Serializable{
	private Integer btid; // 图书类型编号
	private String typename; // 图书类型名称
}
