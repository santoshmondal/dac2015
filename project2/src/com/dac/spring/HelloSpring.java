package com.dac.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * santosh.ece06@gmail.com
 * @author santoshm
 *
 */
public class HelloSpring {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myfirstspirngxml.xml");
		
		
		MySpringBean bean = (MySpringBean)context.getBean("refName");
		System.out.println( "OBJECT CREATED BY SPRING :: " + bean);
		System.out.println(bean.getMessage());
		
		context.close();
	}
}
