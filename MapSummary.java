package cn.kkcoder.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class MapSummary {

	public static void main(String[] args) {
		
	}
	
	private void mainAPI() {

		
		/**
		 * HashMap 	继承自抽象类AbstractMap（实现了Map 接口的方法）
		 * 			
		 * 			1.以键值对的方式存储内容
		 * 			2.线程不安全
		 * 			3.无序的
		 * 			
		 * 
		 */
		Map hashmap = new HashMap<>();
		/**
		 * TreeMap  继承于AbstractMap，且实现了NavigableMap(继承SortedMap(继承Map接口 ) 接口 )接口
		 * 			
		 * 			1.以键值对的方式存储内容
		 * 			2.线程不安全
		 * 			3.有序的
		 * 
		 * 
		 * 
		 */
		Map treemap = new  TreeMap<>();
		
		/**
		 * Hashtable  继承于抽象类Dictionary(Dictionary也是键值对的接口 )，而且也实现Map接口
		 * 			
		 * 			1.以键值对的方式存储内容
		 * 			2.线程安全
		 * 			3.无序的
		 * 
		 * 
		 * 
		 */
		Map hashtable = new Hashtable<>();
	}
}
