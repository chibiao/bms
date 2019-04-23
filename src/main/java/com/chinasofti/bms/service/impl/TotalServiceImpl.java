package com.chinasofti.bms.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.bms.dao.BookDao;
import com.chinasofti.bms.dao.BorrowBookDao;
import com.chinasofti.bms.dao.ReaderDao;
import com.chinasofti.bms.dao.UserDao;
import com.chinasofti.bms.dao.impl.BookDaoImpl;
import com.chinasofti.bms.dao.impl.BorrowBookDaoImpl;
import com.chinasofti.bms.dao.impl.ReaderDaoImpl;
import com.chinasofti.bms.dao.impl.UserDaoImpl;
import com.chinasofti.bms.domain.Book;
import com.chinasofti.bms.domain.BorrowBook;
import com.chinasofti.bms.domain.Reader;
import com.chinasofti.bms.domain.User;
import com.chinasofti.bms.service.TotalService;

public class TotalServiceImpl implements TotalService {
	private ReaderDao readerDao= new ReaderDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private BorrowBookDao borrowBookDao = new BorrowBookDaoImpl();
	
	/**
	 * 读者登录服务
	 */
	public Reader readLogin(Integer rid, String password) {
		//System.out.println(rid+"---"+password);
		try {
			return readerDao.getReader(rid, password);
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * 根据图书名称查询图书
	 */
	public List<Book> getBooksByName(String bname) {
		try {
			return bookDao.getBooksByName(bname);
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * 根据图书编号查询图书
	 */
	public Book getBooksById(Integer bid) {
		try {
			return bookDao.getBookById(bid);
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * 根据图书类型编号查询图书
	 */
	public List<Book> getBooksByTypeId(int typeId) {
		try {
			List<Book> allbooks = bookDao.getAllbooks();
			List<Book> books = new ArrayList<Book>();
			for (Book book : allbooks) {
				//typeId==book.getBtid() false  地址不同
				if(book.getBtid()==typeId){
					books.add(book);
				}
			}
			return books;
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * 获取所有图书
	 */
	public List<Book> getAllBooks() {
		try {
			return bookDao.getAllbooks();
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * 管理员登录
	 */
	public User userLogin(int id, String pwd) {
		try {
			return userDao.getUser(id, pwd);
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * 通过图书id删除图书
	 */
	public Boolean deleteBook(Integer id) {
		try {
			bookDao.deleteBookById(id);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	/**
	 * 添加图书
	 */
	public Boolean addBook(Book book) {
		try {
			bookDao.insertBook(book);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	/**
	 * 修改图书
	 */
	public Boolean updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public List<Reader> getAllReader() {
		try {
			return readerDao.getAllReader();
		} catch (SQLException e) {
			return null;
		}
	}
	public Reader getReaderById(int id) {
		try {
			return readerDao.getReaderById(id);
		} catch (SQLException e) {
			return null;
		}
	}
	public boolean addReader(Reader reader) {
		try {
			readerDao.insertReader(reader);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public boolean updateReader(Reader reader) {
		try {
			readerDao.updateReader(reader);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public boolean deleteReader(int id) {
		try {
			readerDao.deleteReaderById(id);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public List<User> getAllUser() {
		try {
			return userDao.getAllUser();
		} catch (SQLException e) {
			return null;
		}
	}
	public User getUserById(int id) {
		try {
			return userDao.getUserById(id);
		} catch (SQLException e) {
			return null;
		}
	}
	public boolean updateUser(User user) {
		try {
			userDao.updateUser(user);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public boolean addUser(User user) {
		try {
			userDao.insertUser(user);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public boolean deleteUser(int id) {
		try {
			userDao.deleteUserById(id);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public boolean borrowBook(Reader reader) {
		List<BorrowBook> borrowBook = reader.getBorrowBook();
		for (BorrowBook borrowBook2 : borrowBook) {
			try {
				if(borrowBookDao.getBorrowBooksByRidAndBid(reader.getRid(), borrowBook2.getBid())==null){
					Book book = bookDao.getBookById(borrowBook2.getBid());
					if(book.getBnumber()-1>=0){
						readerDao.updateReader(reader);
						borrowBookDao.insertBorrowBook(borrowBook2);
						book.setBnumber(book.getBnumber()-1);
						bookDao.updateBook(book);
						return true;
					}else{
						return false;
					}
				}
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
	public boolean returnBook(BorrowBook borrowBook) {
		try {
			borrowBookDao.deleteBorrowBookByRidAndBid(borrowBook.getRid(), borrowBook.getBid());
			Book book = bookDao.getBookById(borrowBook.getBid());
			book.setBnumber(book.getBnumber()+1);
			bookDao.updateBook(book);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public BorrowBook getBorrowBookById(int rid,int bid) {
		try {
			return borrowBookDao.getBorrowBooksByRidAndBid(rid, bid);
		} catch (SQLException e) {
			return null;
		}
		
	}
}
