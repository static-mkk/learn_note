package cn.kkcoder.learn.aop_aspect;

import org.springframework.stereotype.Component;

@Component
public class Student {

	String name;
	String age;
	
	public void setAge(String age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public  void saveStudent(){
		System.out.println("save student !");
		
	}
	public void throwNew() {

		System.out.println("throw new ");
		throw new RuntimeException("00000000000");
	}
	
	
}
