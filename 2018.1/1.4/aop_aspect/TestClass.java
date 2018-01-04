package cn.kkcoder.learn.aop_aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
		Student s =  (Student) context.getBean("student");
		s.setAge("```");
		s.setName("makai ");
		s.saveStudent();
		System.out.println(s.getName());
		s.throwNew();
		
		
	}
	
}
