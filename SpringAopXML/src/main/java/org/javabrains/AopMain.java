package org.javabrains;

import org.javabrains.service.FactoryService;
import org.javabrains.service.ShapeService;

public class AopMain {
	
	public static void main(String[] args) {
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		
//		shapeService.getCircle().setName("Dummy Name");
		shapeService.getCircle();
		
//		System.out.println(shapeService.getCircle().getName());
*/		
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		shapeService.getCircle();
		
	}
}
