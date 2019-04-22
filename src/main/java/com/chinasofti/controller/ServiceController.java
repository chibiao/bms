package com.chinasofti.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.chinasofti.bms.service.TotalService;
import com.chinasofti.bms.service.impl.TotalServiceImpl;

//bms服务器
public class ServiceController {
	private static final int PORT = 12345; // 端口号
	private static int MAX_POOL = 10; // 连接池最大连接数
	private ServerSocket server; // 服务器套接字对象
	private ExecutorService pool; // 线程池
	private TotalService totalService; 

	public ServiceController() {
		try {
			server=new ServerSocket(PORT);
			pool=Executors.newFixedThreadPool(MAX_POOL);
			System.out.println("服务器启动成功");
			totalService = new TotalServiceImpl();
		} catch (IOException e) {
			System.out.println("服务器启动失败");
		}
	}

	public void start() {
		while(true){
			try {
				//等待客户端连接
				Socket client = server.accept();
				//创建线程对象
				ControllerThread ct = new ControllerThread(client,totalService);
				//交给线程池
				pool.submit(ct);
				/*//启动线程
				Thread t= new Thread(ct);
				t.start();*/
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
