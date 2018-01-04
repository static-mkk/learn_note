aop 基于 注解的 方式
<br/>
@Aspect  注解在 切面类上   <br/>
并且在 xml 中 配置 <br/>
    <!-- 启用对Aspectj注解的支持 --><br/>
    <aop:aspectj-autoproxy/><br/>
    
该切面类 也需要 @component 来注入 </br>
@Before("execution(* cn.kkcoder.learn.aop_aspect.*.*(..))") <br/>
	public void beforeAll(){ <br/>
		System.out.println("111111"); <br/>
	} <br/>