aop ���� ע��� ��ʽ
<br/>
@Aspect  ע���� ��������   <br/>
������ xml �� ���� <br/>
    <!-- ���ö�Aspectjע���֧�� --><br/>
    <aop:aspectj-autoproxy/><br/>
    
�������� Ҳ��Ҫ @component ��ע�� </br>
@Before("execution(* cn.kkcoder.learn.aop_aspect.*.*(..))") <br/>
	public void beforeAll(){ <br/>
		System.out.println("111111"); <br/>
	} <br/>