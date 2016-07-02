package org.javabrains.service;

import org.javabrains.aspect.Loggable;
import org.javabrains.model.Circle;
import org.javabrains.model.Triangle;

public class ShapeService {
	
	private Circle circle;
	private Triangle triangle;
	
	@Loggable
	public Circle getCircle() {
		System.out.println("Circle getter called.");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
 }
