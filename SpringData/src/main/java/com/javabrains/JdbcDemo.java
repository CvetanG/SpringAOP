package com.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.dao.JdbcDaoImpl;
import com.javabrains.model.Circle;

public class JdbcDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
//		Circle circle = new JdbcDaoImpl().getCircle(1);
//		Circle circle = dao.getCircle(1);
//		System.out.println(circle.getName());
		
		System.out.println(dao.getCircleCount());
		System.out.println(dao.getCircleName(1));
		System.out.println(dao.getCircleforId(1).getName());
		System.out.println(dao.getAllCircle().size());
		
		dao.insertCircle(new Circle(2, "Second Circle"));
		
		dao.createTriangleTable();
		
	}
}
