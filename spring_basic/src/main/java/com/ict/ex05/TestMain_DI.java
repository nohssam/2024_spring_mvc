package com.ict.ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain_DI {
	public static void main(String[] args) {
		ApplicationContext context =
			new GenericXmlApplicationContext("com/ict/ex05/config.xml");
		
		MyProcess myProcess = (MyProcess) context.getBean("mp");
		myProcess.prn();
	}
}
