package com.chinasofti.bms.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.chinasofti.bms.domain.Book;
import com.chinasofti.bms.utils.ExeclUtil;

public class ExcelTest {
	@Test
	public void test() throws Exception {
		List<Book> li = new ArrayList<Book>();
		Book book = new Book();
		book.setBid(11111);
		book.setBname("111");
		li.add(book);
		OutputStream out = new FileOutputStream("d://aa.xls");
		Map<String, String> fields = new HashMap<String, String>();
		fields.put("bid", "书籍编号");
		fields.put("bname", "书名字");
		ExeclUtil.ListtoExecl(li, out, fields);
		out.close();
	}
}
