package com.chinasofti.controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ControllerThread implements Runnable {
	private Socket client;
	//被代理的对象
	private Object obj;

	public ControllerThread(Socket client, Object obj) {
		super();
		this.client = client;
		this.obj = obj;
	}


	public void run() {
		ObjectInputStream ois;
		ObjectOutputStream oos;
		try {
			ois = new ObjectInputStream(client.getInputStream());
			//获取方法名字
			String methodName = ois.readUTF();
			//获取参数类型
			Class<?>[] methodTypes=(Class<?>[])ois.readObject();
			//获取参数
			Object[] methodParames = (Object[])ois.readObject();
			//获取方法
			Method method = obj.getClass().getMethod(methodName, methodTypes);
			//调用方法
			Object result = method.invoke(obj, methodParames);
			//System.out.println(methodParames.toString());
			//System.out.println(result);
			oos = new ObjectOutputStream(client.getOutputStream());
			oos.writeObject(result);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
