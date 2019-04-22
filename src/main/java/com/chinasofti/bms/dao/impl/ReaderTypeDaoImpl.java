package com.chinasofti.bms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.bms.dao.ReaderTypeDao;
import com.chinasofti.bms.domain.ReaderType;
import com.chinasofti.bms.utils.JDBCUtil;

public class ReaderTypeDaoImpl implements ReaderTypeDao {
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

	public List<ReaderType> getAllReadType() throws SQLException {
		String sql = "select * from readertype";
		return qr.query(sql, new BeanListHandler<ReaderType>(ReaderType.class));
	}

	public void updateReadType(ReaderType readType) throws SQLException {
		String sql = "update readertype set typename=?,maxborrownum=?,limitday=? where tid=?";
		qr.update(sql, readType.getTypename(), readType.getMaxborrownum(),
				readType.getLimitday(), readType.getTid());
	}

	public void deleteReadType(int id) throws SQLException {
		String sql = "delete from readertype where tid=?";
		qr.update(sql, id);
	}

	public void insertReadType(ReaderType readType) throws SQLException {
		String sql = "insert into readertype(typename,maxborrownum,limitday) values(?,?,?)";
		qr.update(sql, readType.getTypename(), readType.getMaxborrownum(),
				readType.getLimitday());
	}

}
