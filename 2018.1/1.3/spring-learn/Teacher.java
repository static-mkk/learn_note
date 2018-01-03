package cn.kkcoder.learn.aop.javabean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teacher {

	@Autowired
	Student student;
	
	public void sayTeacher() {
		System.out.println("this is sayTeacher method  ");
	}
	
	public void stuToString(){
		this.student.name = "马凯";
		this.student.age = "22";
		System.out.println(this.student.toString());
	}
	
	public void stuSay(){
		this.student.sayStudent();
	}
}
