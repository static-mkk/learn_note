package cn.kkcoder.learn.aop_aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectjTest {
	
//   这个 @pointcut 注解 没看懂， 切面的话，还是直接写 execution 表达式吧 
//	@Pointcut("execution(* cn.kkcoder.learn.aop_aspect.*.*(..))")
//	private void selectAll() {
//	}
	
	
	@Before("execution(* cn.kkcoder.learn.aop_aspect.*.*(..))")
	public void beforeAll(){
		System.out.println("111111");
	}
	
	@After(value = "execution(* cn.kkcoder.learn.aop_aspect.*.*(..))")
	public void afterAll(){
		System.out.println("222222");
	}
	
	@AfterThrowing(pointcut = "execution(* cn.kkcoder.learn.aop_aspect.*.*(..))" ,throwing = "ex")
	public void throwsAfter(Exception ex){
		System.out.println(ex.getMessage());
	}
	
	
}
