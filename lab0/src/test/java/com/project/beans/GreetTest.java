package com.project.beans;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetTest {

	@Test
	public void testGetGreeting() {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");){
			Greet greet =(Greet) context.getBean("greet");
			System.out.println(greet.getGreeting());
		}
	}

}
