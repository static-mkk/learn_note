package cn.kkcoder.learn.aop.javabean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Teacher t = (Teacher) context.getBean("teacher");
		t.sayTeacher();
		t.stuToString();
		/**不知道为什么，但是这里的确是没有注入t里面的student ？ */
		System.out.println(t.student);
		
		Student s = (Student) context.getBean("student");
		s.age = "123";
		/**不知道为什么这里，给age赋值，却显示null ？ */
		System.out.println(s.hashCode());
		
	}
	
}
