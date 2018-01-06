package cn.kkcoder.spring_mvc.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author static-mkk 
 * @date 6 Jan 2018  4:28:26 PM
 * @myblog  www.kkcoder.cn
 *
 *  student 类
 */

@Component
public class Student {
	
	String name;
	String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	

}
