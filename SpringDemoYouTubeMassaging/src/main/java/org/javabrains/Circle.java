package org.javabrains;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
	
	private Point center;

	@Autowired
	private MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void draw() {
		System.out.println(this.messageSource.getMessage("drawin.circle", null, "Default Drawing Greeing", null));
		System.out.println(this.messageSource.getMessage("drawin.point", new Object[] {center.getX(), center.getY()}, "Default Point Greeing", null));
		System.out.println(this.messageSource.getMessage("greeting", null, "Default  Greeing", null));
	}

	public Point getCenter() {
		return center;
	}

//	@Required
	
//	@Autowired
//	@Qualifier("circleRelated")
	
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init of Circle");
	}
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy of Circle");
	}
	
}
