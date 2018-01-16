package cn.kkcoder.learn.annotatiion;

import java.lang.reflect.Field;

/**
 * 
 * @author static-mkk 
 * @time 5:18:23 PM
 * @myblog  www.kkcoder.cn<br/>
 *
 *    利用注解实现类属性值得注入 
 *  
 */
public class AnnotationMain {

	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		
		Persion p = new Persion();
		
		
		/**获取需要解析注解的类的对象*/
		Class<? extends Object> persion = cn.kkcoder.learn.annotatiion.Persion.class;
		
		/**1.获取所有的属性信息    java.lang.reflect.Field */
		
		/**
		 *  关于class对象的  getDeclaredFields
		 *  	返回 Field 对象的一个数组，这些对象反映此 Class对象所表示的类或接口所声明的    <b>所有字段<b>。
		 *      包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。
		 *      
	     *   关于class对象的  getFields 
	     *   	返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象
	     *      所表示的类或接口的所有可访问公共字段。
		 * 
		 * 
		 */
		
		Field[] fields = persion.getDeclaredFields();
		
		/**2.循环遍历，遍历判断属性上是否有注解：有，注入  */
		for(Field f : fields){
			//设置是否可以修改 field 的 值     1.6 的 api 里没有这个方法
			f.setAccessible(true);
			
			//判断 f 属性上是否有 类型为 TESTAnnotation 的注解， 如果有，返回该注解 对象    否则 返回 null
			boolean isAnno =  f.isAnnotationPresent(TestAnnotation.class);
			
			
			if(isAnno ){
				TestAnnotation anno  = f.getAnnotation(TestAnnotation.class);
				
				int    age     =      anno.age();
				String name    =      anno.name();
				String fName = f.getName();         //属性名
				
				if(fName.equals("age")){  // 放到 对象里面 ，可以用于返回该注解产生的对象
					p.setAge(age);
				}else{
					p.setName(name);
				}
			}
		}
		
		System.out.println( "age : " + p.getAge() + "name : " + p.getName() );
		//  测试结果正确    age : 33name : mmmmm
		
	}
	
}
