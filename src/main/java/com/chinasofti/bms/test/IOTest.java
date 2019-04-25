package com.chinasofti.bms.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.chinasofti.bms.domain.Book;
import com.chinasofti.bms.service.TotalService;
import com.chinasofti.bms.service.impl.TotalServiceImpl;
import com.chinasofti.bms.utils.ExeclUtil;
import com.chinasofti.bms.utils.StringUtil;

public class IOTest {
	private TotalService totalService = new TotalServiceImpl();

	@Test
	public void test() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("a.xls"));
		/*Book book = new Book();
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
		}*/
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
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
	@Test
	public void test3() throws Exception {
		List<Book> li = new ArrayList<Book>();
		List<Book> allBooks = totalService.getAllBooks();
		for (Book book : allBooks) {
			li.add(book);
		}
		OutputStream out = new FileOutputStream("d://aa.xls");
		Map<String, String> fields = new HashMap<String, String>();
		fields.put("bid", "图书编号");
		fields.put("btid", "图书类型编号");
		fields.put("bname", "图书名称");
		fields.put("author", "图书作者");
		fields.put("publish", "出版社");
		fields.put("bnumber", "图书数量");
		fields.put("price", "图书价格");
		ExeclUtil.ListtoExecl(li, out, fields);
		out.close();
	}
	@Test
	public void test4() throws Exception{
		Map<String, String> fields = new HashMap<String, String>();
		InputStream in =new FileInputStream("d://aa.xls");
		fields.put("图书类型编号", "btid");
		fields.put("图书名称", "bname");
		fields.put("图书作者", "author");
		fields.put("出版社", "publish");
		fields.put("图书数量", "bnumber");
		fields.put("图书价格", "price");
		List<Book> books = ExeclUtil.ExecltoList(in, Book.class, fields);
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
