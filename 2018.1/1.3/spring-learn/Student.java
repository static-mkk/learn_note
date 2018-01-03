package cn.kkcoder.learn.aop.javabean;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	public Student() {
		System.out.println(" student inner ");
	}

	
	public  String name;
	public  String age;
	
	public  void sayStudent() {
		System.out.println("this is student sayStudent method ");
	}
	
	/*
	@Bean
	public Student student(){
		return new Student();
	}
	
	
		这里不能用@Bean
			@Bean  : 是在带有  @Configuration 注解的配置类中，用于声明 返回一个 bean 对象
			@Configuration ： 相当于自己写的 配置类，使用时，
							    需要用 new AnnotationConfigApplicationContext(HelloWorldConfig.class); 
							    来添加配置信息，然后才能获取该配置类中的 注解有@Bean 的对象 
		  	
		  	获取对象时： context.getBean(HelloWorld.class);
		  	
		  一般 @Bean 应该都是在  注有 @configuration 的类中使用 	
	
	*/

	@Override
	public String toString() {
		return "this is student to string " + this.name +"  "+ this.age;
	}

}
