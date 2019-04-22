package com.chinasofti.bms.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.chinasofti.bms.dao.BookDao;
import com.chinasofti.bms.dao.impl.BookDaoImpl;
import com.chinasofti.bms.domain.Book;
import com.chinasofti.bms.service.TotalService;
import com.chinasofti.bms.service.impl.TotalServiceImpl;

public class BookTest {
	private Book book = new Book();
	private BookDao bookDao = new BookDaoImpl();
	private TotalService bookService = new TotalServiceImpl();
	@Test
	public void test() throws SQLException{
		List<Book> allbooks = bookDao.getAllbooks();
		for (Book book : allbooks) {
			System.out.println(book);
		}
	}
	@Test
	public void test2() {
		try {
			bookDao.deleteBookById(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test3(){
		/*List<Book> allBooks = bookService.getAllBooks();
		for (Book book : allBooks) {
			System.out.println(book);
		}*/
		Book book = bookService.getBooksById(1);
		//System.out.println(booksById);
		/*List<Book> booksByName = bookService.getBooksByName("骆驼祥子");
		System.out.println(booksByName);*/
//		List<Book> booksByTypeId = bookService.getBooksByTypeId(2);
//		System.out.println(booksByTypeId);
		System.out.println("图书编号\t\t图书类型编号\t图书名称\t\t出版社\t\t作者\t\t数量\t\t价格");
		System.out.println(book.getBid()+"\t\t"+book.getBtid()+"\t\t"+book.getBname()+"\t\t"+
		book.getPublish()+"\t"+book.getAuthor()+"\t\t"+book.getBnumber()+"\t\t"+book.getPrice());
		
	}
	@Test
	public void test4() throws SQLException{
		book.setAuthor("鲁迅");
		book.setBname("狂人日记");
		book.setBtid(1);
		book.setBnumber(10);
		book.setPrice(50.5);
		book.setPublish("北京大学出版社");
		bookDao.insertBook(book);
	}
	@Test
	public void test5() throws SQLException{
		book.setAuthor("鲁迅");
		book.setBname("狂人日记");
		book.setBtid(1);
		book.setBnumber(15);
		book.setPrice(50.5);
		book.setPublish("北京大学出版社");
		book.setBid(3);
		bookDao.updateBook(book);
	}
	@Test
	public void test6() throws SQLException{
		bookDao.deleteBookById(3);
	}

}
