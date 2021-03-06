package com.chinasofti.bms.service;

import java.util.List;

import com.chinasofti.bms.domain.Book;
import com.chinasofti.bms.domain.BookType;
import com.chinasofti.bms.domain.BorrowBook;

public interface BookService {
	/**
	 * 查询所有图书
	 * @return
	 */
	List<Book> getAllBooks();

	/**
	 * 根据图书编号查询
	 * @param bid
	 * @return
	 */
	Book getBooksById(Integer bid);

	/**
	 * 根据图书类型查询
	 * @param typeId
	 * @return
	 */
	List<Book> getBooksByTypeId(int typeId);

	/**
	 * 根据图书名称查询
	 * @param bname
	 * @return
	 */
	List<Book> getBooksByName(String bname);

	/**
	 * 根据图书编号删除图书
	 * @param id
	 * @return
	 */
	boolean deleteBook(Integer id);

	/**
	 * 添加书籍
	 * @param book
	 * @return
	 */
	boolean addBook(Book book);

	/**
	 * 修改书籍
	 * @param book
	 * @return
	 */
	boolean updateBook(Book book);
	/**
	 * 通过读者编号和图书编号查询借阅信息
	 * @param rid
	 * @param bid
	 * @return
	 */
	BorrowBook getBorrowBookById(int rid,int bid);
	/**
	 * 获取最后一个插入的图书
	 * @return
	 */
	Book getLastBook();
	/**
	 * 获取所有图书类型
	 * @return
	 */
	List<BookType> getAllBookType();
	/**
	 * 批量导入图书信息
	 * @param books
	 * @return
	 */
	boolean insertBatchBook(List<Book> books);
	boolean addBookType(BookType bookType);
	boolean updateBookType(BookType bookType);
	boolean deleteBookType(int btid);

}
