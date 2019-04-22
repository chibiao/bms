package com.chinasofti.bms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.bms.dao.BookTypeDao;
import com.chinasofti.bms.domain.BookType;
import com.chinasofti.bms.utils.JDBCUtil;

public class BookTypeDaoImpl implements BookTypeDao {
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

	public List<BookType> getAllBookType() throws SQLException {
		String sql="select * from booktype";
		return qr.query(sql, new BeanListHandler<BookType>(BookType.class));
	}

	public void updateBookType(BookType bookType) throws SQLException {
		String sql="update booktype set typename=? where btid=?";
		qr.update(sql, bookType.getTypename(),bookType.getBtid());
	}

	public void deleteBookTypeById(int btid) throws SQLException {
		String sql="delete from booktype where btid=?";
		qr.update(sql, btid);
	}

	public void insertBookType(BookType bookType) throws SQLException {
		String sql="insert into booktype(typename) values(?)";
		qr.update(sql, bookType.getTypename());
	}

}
