package com.chinasofti.bms.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.bms.dao.BookDao;
import com.chinasofti.bms.dao.BookTypeDao;
import com.chinasofti.bms.dao.BorrowBookDao;
import com.chinasofti.bms.dao.ReaderDao;
import com.chinasofti.bms.dao.ReaderTypeDao;
import com.chinasofti.bms.dao.UserDao;
import com.chinasofti.bms.dao.impl.BookDaoImpl;
import com.chinasofti.bms.dao.impl.BookTypeDaoImpl;
import com.chinasofti.bms.dao.impl.BorrowBookDaoImpl;
import com.chinasofti.bms.dao.impl.ReaderDaoImpl;
import com.chinasofti.bms.dao.impl.ReaderTypeDaoImpl;
import com.chinasofti.bms.dao.impl.UserDaoImpl;
import com.chinasofti.bms.domain.Book;
import com.chinasofti.bms.domain.BookType;
import com.chinasofti.bms.domain.BorrowBook;
import com.chinasofti.bms.domain.Reader;
import com.chinasofti.bms.domain.ReaderType;
import com.chinasofti.bms.domain.User;
import com.chinasofti.bms.service.TotalService;

public class TotalServiceImpl implements TotalService {
	private ReaderDao readerDao = new ReaderDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private BookTypeDao bookTypeDao = new BookTypeDaoImpl();
	private BorrowBookDao borrowBookDao = new BorrowBookDaoImpl();
	private ReaderTypeDao readerTypeDao = new ReaderTypeDaoImpl();

	/**
	 * 读者登录服务
	 */
	public Reader readLogin(Integer rid, String password) {
		// System.out.println(rid+"---"+password);
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
				// typeId==book.getBtid() false 地址不同
				if (book.getBtid() == typeId) {
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
	public boolean deleteBook(Integer id) {
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
	public boolean addBook(Book book) {
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
	public boolean updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * 获取所有读者
	 */
	public List<Reader> getAllReader() {
		try {
			return readerDao.getAllReader();
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * 通过读者编号查询
	 */
	public Reader getReaderById(int id) {
		try {
			return readerDao.getReaderById(id);
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * 添加读者
	 */
	public boolean addReader(Reader reader) {
		try {
			readerDao.insertReader(reader);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * 修改读者
	 */
	public boolean updateReader(Reader reader) {
		try {
			readerDao.updateReader(reader);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * 删除读者
	 */
	public boolean deleteReader(int id) {
		try {
			readerDao.deleteReaderById(id);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * 获取所有管理员
	 */
	public List<User> getAllUser() {
		try {
			return userDao.getAllUser();
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * 通过id查询管理员
	 */
	public User getUserById(int id) {
		try {
			if (userDao.getUserById(id) != null) {
				if ("admin".equals(userDao.getUserById(id).getUname())) {
					return null;
				}else{
					return userDao.getUserById(id);
				}
			}else{
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * 更新管理员信息
	 */
	public boolean updateUser(User user) {
		try {
			userDao.updateUser(user);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * 添加管理员
	 */
	public boolean addUser(User user) {
		try {
			userDao.insertUser(user);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * 删除管理员
	 */
	public boolean deleteUser(int id) {
		try {
			if(userDao.getUserById(id)!=null){
				if (userDao.getUserById(id).getUname().equals("admin")) {
					return false;
				} else {
					userDao.deleteUserById(id);
					return true;
				}
			}else{
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * 读者借阅图书
	 */
	public boolean borrowBook(Reader reader) {
		List<BorrowBook> borrowBook = reader.getBorrowBook();
		if (borrowBook.size() >= reader.getReadType().getMaxborrownum()) {
			return false;
		} else {
			for (BorrowBook borrowBook2 : borrowBook) {
				try {
					if (borrowBookDao.getBorrowBooksByRidAndBid(
							reader.getRid(), borrowBook2.getBid()) == null) {
						Book book = bookDao.getBookById(borrowBook2.getBid());
						if (book.getBnumber() - 1 >= 0) {
							readerDao.updateReader(reader);
							borrowBookDao.insertBorrowBook(borrowBook2);
							book.setBnumber(book.getBnumber() - 1);
							bookDao.updateBook(book);
							return true;
						} else {
							return false;
						}
					}
				} catch (SQLException e) {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * 归还图书
	 */
	public boolean returnBook(BorrowBook borrowBook) {
		try {
			borrowBookDao.deleteBorrowBookByRidAndBid(borrowBook.getRid(),
					borrowBook.getBid());
			Book book = bookDao.getBookById(borrowBook.getBid());
			book.setBnumber(book.getBnumber() + 1);
			bookDao.updateBook(book);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * 通过读者编号和图书编号查询借阅信息
	 */
	public BorrowBook getBorrowBookById(int rid, int bid) {
		try {
			return borrowBookDao.getBorrowBooksByRidAndBid(rid, bid);
		} catch (SQLException e) {
			return null;
		}

	}

	/**
	 * 批量添加读者
	 */
	public boolean batchAddReader(int count, int readerType) {
		Reader reader = new Reader();
		reader.setMoney(100.0);
		reader.setPassword("123456");
		reader.setTid(readerType);
		for (int i = 0; i < count; i++) {
			try {
				readerDao.insertReader(reader);
			} catch (SQLException e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取最后插入的读者
	 */
	public Reader getLastReader() {
		try {
			return readerDao.getLastReader();
		} catch (SQLException e) {
			return null;
		}
	}

	public List<Reader> getLastReader(int count) {
		try {
			return readerDao.getLastReader(count);
		} catch (SQLException e) {
			return null;
		}
	}

	public Book getLastBook() {
		try {
			return bookDao.getLastBook();
		} catch (SQLException e) {
			return null;
		}
	}

	public List<BookType> getAllBookType() {
		try {
			return bookTypeDao.getAllBookType();
		} catch (SQLException e) {
			return null;
		}
	}

	public List<ReaderType> getAllReadType() {
		try {
			return readerTypeDao.getAllReadType();
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean insertBatchBook(List<Book> books) {
		if (books != null) {
			for (Book book : books) {
				try {
					bookDao.insertBook(book);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}

	public boolean addBookType(BookType bookType) {
		try {
			bookTypeDao.insertBookType(bookType);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean updateBookType(BookType bookType) {
		try {
			bookTypeDao.updateBookType(bookType);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean deleteBookType(int btid) {
		try {
			bookTypeDao.deleteBookTypeById(btid);
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
}
