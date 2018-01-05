package cn.kkcoder.learn.jdbcTemplete;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {
	
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("jdbc.xml");
		StudentJdbcTemp s = (StudentJdbcTemp) c.getBean("studentJdbcTemp");
		s.create("mkk", "asd", 2);
		s.updateById(2, "myy","12");
		List<Student> s1 = s.getStudent(1);
		System.out.println(s1.get(0).getName());
	}
}
