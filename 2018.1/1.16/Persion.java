package cn.kkcoder.learn.annotatiion;


/**
 * 
 * @author static-mkk 
 * @time 5:16:07 PM
 * @myblog  www.kkcoder.cn
 * <br>
 *  使用注解的类
 *  
 */
public class Persion {

	@TestAnnotation(name="mmmmm")
	String name ;
	@TestAnnotation(age = 33 )
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
