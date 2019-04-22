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
 *		图书信息
 */
public class Book implements Serializable{
	private Integer bid;// 图书编号
	private Integer btid;// 图书类型编号
	private String bname;// 图书名称
	private String author;// 图书作者
	private String publish;// 出版社
	private Integer bnumber;// 图书数量
	private Double price;// 图书价格
	private BookType bookType;// 图书类型
}
