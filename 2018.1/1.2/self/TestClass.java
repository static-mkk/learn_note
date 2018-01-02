package cn.kkcoder.learn.aop.self;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.kkcoder.learn.aop.self.service.StudentServiceImpl;


public class TestClass {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentServiceImpl s =  (StudentServiceImpl) context.getBean("StudentServiceImpl");
		s.saveStudent();
	
	}
	
	
}
