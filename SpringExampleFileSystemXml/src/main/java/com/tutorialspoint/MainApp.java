package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {

      ApplicationContext context = new FileSystemXmlApplicationContext
//            ("C:/Users/ZARA/workspace/HelloSpring/src/Beans.xml");
      ("//home/cvetan/workspace/SpringExampleFileSystemXml/src/main/java/Beans.xml");
//      ("target/classes/Beans.xml");
//      ("/target/classes/Beans.xml");

      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
   }
}
