package org.javabrains.service;

import org.javabrains.model.Circle;
import org.javabrains.model.Triangle;

public class FactoryService {
	
	public Object getBean(String beanType) {
//		if (beanType.equals("shapeService")) return new ShapeService();
		if (beanType.equals("shapeService")) return new ShapeServiceProxy();
		if (beanType.equals("circle")) return new Circle();
		if (beanType.equals("triangle")) return new Triangle();
		return null;
	}
}
