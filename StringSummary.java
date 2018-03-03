package cn.kkcoder.map;
/**
 * 
 * @author static-mkk 
 * @time 3 Mar 2018
 * @myblog  www.kkcoder.cn
 *
 */

public class StringSummary {

	/**
	 *		字符串
	 *    	如： String a="q" ;String b="q"; 		
	 *    
	 *    	定义 	：		unicode字符序列。
	 *      tips	：		1.string类对象时不可变对象
	 *      				2.== 和  equals（）的区别
	 *      					i. == 表示两个string 对象的索引的比较. a==b;  true;因为a，b的索引都是直接指向string对象q
	 * 							ii.equals() 比较两个对象的值是否相等.  a.equals(b); true; 因为值相等.
	 * 						3.JVM只会共享字符串常量。     --> 所以，尽量少用==来比较字符串是否相等.
	 * 						4.null 和   "" 是不一样的。
	 * 							i.null 表示对象为空。
	 * 							ii."" 表示一个字符串内容为空，长度为0的字符串.
	 * 						5.String 字符串下标从0开始.
	 * 
	 * 		字符串常用API示例于main方法用演示说明.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		String name =  "hello";
		
		name.charAt(0);				//返回字符串指定下标对应的字符
		name.equals("hell");		//返回boolean类型结果
		name.indexOf("l");			//返回第一个"l"对应的索引值.
		name.lastIndexOf("l");		//返回最后一个"l"对应的索引值.
		name.length();				//返回字符串的长度.
		name.substring(0, 1);		//返回起始索引为0，结束索引为1（但不包括索引1对应的字符）的sting对象。
		name.split("l");			//返回以"l"作为分隔符,分割出的String 数组.
		name.replace("l", "p");		//返回用"p"来代替原String对象中"l"，之后的String对象.
		name.trim();				//返回 该字符串删除开头和结尾字符串的空格 之后的String对象.
		name.endsWith("lo");		//返回boolean类型值，name对象值若以"lo"结尾，返回true，否则，返回false.
		
	}
	
	
	
	
	
}
