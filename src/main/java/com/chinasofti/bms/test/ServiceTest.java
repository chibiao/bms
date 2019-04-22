package com.chinasofti.bms.test;

import org.junit.Test;

import com.chinasofti.controller.ServiceController;

public class ServiceTest {
	@Test
	public void test(){
		new ServiceController().start();
	}
}
