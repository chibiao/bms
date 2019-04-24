package com.chinasofti.bms.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.chinasofti.bms.domain.Book;
import com.chinasofti.bms.service.TotalService;
import com.chinasofti.bms.service.impl.TotalServiceImpl;
import com.chinasofti.bms.utils.StringUtil;

public class IOTest {
	private TotalService totalService = new TotalServiceImpl();

	@Test
	public void test() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("a.txt"));
		Book book = new Book();
		List<Book> list = new ArrayList<Book>();
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] str = line.split("=");
			if ("btid".equals(str[0])) {
				book.setBtid(Integer.parseInt(str[1]));
			} else if ("bname".equals(str[0])) {
				book.setBname(str[1]);
			} else if ("author".equals(str[0])) {
				book.setAuthor(str[1]);
			} else if ("publish".equals(str[0])) {
				book.setPublish(str[1]);
			} else if ("bnumber".equals(str[0])) {
				book.setBnumber(Integer.parseInt(str[1]));
			} else if ("price".equals(str[0])) {
				book.setPrice(Double.parseDouble(str[1]));
			}
			if (line.equals("---")) {
				list.add(book);
			}
		}
		br.close();
	}

	@Test
	public void test2() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
		List<Book> allBooks = totalService.getAllBooks();
		bw.write("图书编号\t图书类型编号\t\t"+"      "+"图书名称\t\t\t\t\t出版社\t\t\t\t作者\t\t\t\t\t数量\t\t\t\t价格");
		bw.newLine();
		bw.flush();
		for (Book book : allBooks) {
			bw.write(StringUtil.format(book.getBid().toString(), 2)
					+ StringUtil.format(book.getBtid().toString(), 10)
					+ StringUtil.format(book.getBname(), 20)
					+ StringUtil.format(book.getPublish(), 40)
					+ StringUtil.format(book.getAuthor(), 35)
					+ StringUtil.format(book.getBnumber().toString(), 35)
					+ StringUtil.format(book.getPrice().toString(), 20));
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
