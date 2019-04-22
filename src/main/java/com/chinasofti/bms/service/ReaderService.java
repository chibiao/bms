package com.chinasofti.bms.service;

import java.util.List;

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
	public boolean borrowBook(Reader reader);
}
