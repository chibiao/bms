package com.chinasofti.bms.service;

import java.util.List;

import com.chinasofti.bms.domain.BorrowBook;
import com.chinasofti.bms.domain.Reader;

public interface ReaderService {
	/**
	 * 读者登录
	 * @param rid
	 * @param password
	 * @return
	 */
	public Reader readLogin(Integer rid, String password);
	/**
	 * 查询所有读者
	 * @return
	 */
	public List<Reader> getAllReader();
	/**
	 * 通过id查询读者
	 * @param id
	 * @return
	 */
	public Reader getReaderById(int id);
	/**
	 * 获取最后插入的读者信息
	 * @return
	 */
	public Reader getLastReader();
	public List<Reader> getLastReader(int count);
	/**
	 * 添加读者
	 * @param reader
	 * @return
	 */
	public boolean addReader(Reader reader);
	/**
	 * 修改读者信息
	 * @param reader
	 * @return
	 */
	public boolean updateReader(Reader reader);
	/**
	 * 删除读者信息
	 * @param id
	 * @return
	 */
	public boolean deleteReader(int id);
	/**
	 * 批量添加读者
	 * @param count 添加的数量
	 * @param readerType 添加的读者类型
	 * @return
	 */
	public boolean batchAddReader(int count,int readerType);
	/**
	 * 借阅图书
	 * @param reader
	 * @return
	 */
	public boolean borrowBook(Reader reader);
	/**
	 * 归还图书
	 * @param reader
	 * @return
	 */
	public boolean returnBook(BorrowBook borrowBook);
}
