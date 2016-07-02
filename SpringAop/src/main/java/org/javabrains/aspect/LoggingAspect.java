package org.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	/*
//	@Before("execution(public String org.javabrains.model.Circle.getName())")
//	@Before("execution(public String getName())")
//	@Before("execution(public String get*())")
	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Advice run. Get Method called!");
	}
	
	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second Advice executed.");
	}
	
	@Before("allGetters() && allCircleMethods()")
	public void thirthAdvice() {
		System.out.println("Thirth Advice executed.");
	}
	
	// point cut
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}
	
//	@Pointcut("execution(* * org.javabrains.model.Circle.*(..))")
//	public void allCircleMethods() {}
	
	@Pointcut("within(org.javabrains.model.Circle)")
	public void allCircleMethods() {}
	
	@Pointcut("within(org.javabrains.model..*)")
	public void allModelPackagesObjects() {}
	
	*/
	/*
	@Pointcut(args())
	
	*/
	
	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {
//		System.out.println(joinPoint.toString());
		
//		System.out.println(joinPoint.getTarget());
//		Circle circle = (Circle) joinPoint.getTarget();
		
	}
	
//	@Before("args(String)")
//	public void stringArgumentMethods() {
//		System.out.println("A method that takes String arguments has been called");
//	}
	
//	@Before("args(name)")
//	public void stringArgumentMethods(String name) {
//		System.out.println("A method that takes String arguments has been called. The Value is " + name);
//	}
	
	@After("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes String arguments has been called. The Value is " + name);
	}
	
	
	// @AfterReturning(pointcut="args(name)", returning="returnString")
//	public void stringArgumentMethods(String name, Object returnString) {
//		System.out.println("A method that takes String arguments has been called. The Value is " + name + "The output value is: " + returnString);
//	} 
	
	// @AfterThrowing
	
	/*@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		Object returnValue = null;
		
		try {
			System.out.println("Before Advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
		
	}*/
	
	@Around("@annotation(org.javabrains.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		Object returnValue = null;
		
		try {
			System.out.println("Before Advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
		
	}
		
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	@Pointcut("within(org.javabrains.model.Circle)")
	public void allCircleMethods() {}
}
