package org.javabrains.service;

import org.javabrains.aspect.LoggingAspect;
import org.javabrains.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
