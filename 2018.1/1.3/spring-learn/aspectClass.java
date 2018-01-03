package cn.kkcoder.learn.aop.javabean;

import org.springframework.stereotype.Component;

@Component
public class aspectClass {

	public void before(){
		System.out.println("this is before");
	}
	
	public void after(){
		System.out.println("this is after");
	}
}
