package com.chinasofti.bms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.bms.dao.ReaderDao;
import com.chinasofti.bms.domain.BorrowBook;
import com.chinasofti.bms.domain.Reader;
import com.chinasofti.bms.domain.ReaderType;
import com.chinasofti.bms.utils.JDBCUtil;

public class ReaderDaoImpl implements ReaderDao {
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

	public Reader getReader(int rid, String password) throws SQLException {
		String sql = "select * from reader where rid=? and password=?";
		Reader reader = qr.query(sql, new BeanHandler<Reader>(Reader.class), rid,
				password);
		String sql2 = "select * from readertype where tid=?";
		String sql3 = "select * from borrowbook where rid=?";
		reader.setReadType(qr.query(sql2, new BeanHandler<ReaderType>(
				ReaderType.class), reader.getTid()));
		reader.setBorrowBook(qr.query(sql3,
				new BeanListHandler<BorrowBook>(BorrowBook.class),
				reader.getRid()));
		return reader;
	}

	public List<Reader> getAllReader() throws SQLException {
		String sql = "select * from reader";
		List<Reader> readers = qr.query(sql, new BeanListHandler<Reader>(
				Reader.class));
		for (Reader reader : readers) {
			String sql2 = "select * from readertype where tid=?";
			String sql3 = "select * from borrowbook where rid=?";
			reader.setReadType(qr.query(sql2, new BeanHandler<ReaderType>(
					ReaderType.class), reader.getTid()));
			reader.setBorrowBook(qr.query(sql3,
					new BeanListHandler<BorrowBook>(BorrowBook.class),
					reader.getRid()));
		}
		return readers;
	}

	public void deleteReaderById(int id) throws SQLException {
		String sql = "delete from reader where rid=?";
		qr.update(sql, id);
	}

	public void updateReader(Reader reader) throws SQLException {
		String sql = "update reader set tid=?,rname=?,age=?,sex=?,phone=?,dept=?,password=?,money=? where rid=?";
		qr.update(sql, reader.getTid(), reader.getRname(), reader.getAge(),
				reader.getSex(), reader.getPhone(), reader.getDept(),
				reader.getPassword(),reader.getMoney(), reader.getRid());
	}

	public void insertReader(Reader reader) throws SQLException {
		String sql="insert into reader(tid,rname,age,sex,phone,dept,password) values(?,?,?,?,?,?,?)";
		qr.update(sql,reader.getTid(), reader.getRname(), reader.getAge(),
				reader.getSex(), reader.getPhone(), reader.getDept(),
				reader.getPassword());
	}

	public Reader getReaderById(int id) throws SQLException {
		String sql="select * from reader where rid=?";
		Reader reader = qr.query(sql, new BeanHandler<Reader>(Reader.class),id);
		String sql2 = "select * from readertype where tid=?";
		String sql3 = "select * from borrowbook where rid=?";
		reader.setReadType(qr.query(sql2, new BeanHandler<ReaderType>(
				ReaderType.class), reader.getTid()));
		reader.setBorrowBook(qr.query(sql3,
				new BeanListHandler<BorrowBook>(BorrowBook.class),
				reader.getRid()));
		return reader;
	}

}
