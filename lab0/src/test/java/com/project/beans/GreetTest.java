package com.project.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class GreetTest {

	@Test
	void testGetGreeting() {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");){
			Greet greet =(Greet) context.getBean("greet");
			System.out.println(greet.getGreeting());
		}
	}

}
