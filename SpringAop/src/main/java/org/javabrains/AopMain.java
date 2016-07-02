package org.javabrains;

import org.javabrains.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		
//		shapeService.getCircle().setName("Dummy Name");
		shapeService.getCircle();
		
//		System.out.println(shapeService.getCircle().getName());
	}
}
