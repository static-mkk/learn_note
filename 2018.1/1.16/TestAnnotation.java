package cn.kkcoder.learn.annotatiion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author static-mkk 
 * @time 5:13:34 PM
 * @myblog  www.kkcoder.cn
 * <br>
 *
 *   注解反射  demo
 *   	
 */

//这个必须要写注解的 Retention 注解    --> 指明在什么级别显示此注解  RUNTIME JVM会读取注解，同时会保存到class文件中
@Retention(RetentionPolicy.RUNTIME)

//Target  表明 注解  可以 生效的 范围   ElementType.FIELD 表明，类属性可以使用
@Target(ElementType.FIELD)
public @interface TestAnnotation {

	String name() default "MKK";
	int age() default 2;
	
}
