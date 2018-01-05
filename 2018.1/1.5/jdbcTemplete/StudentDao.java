package cn.kkcoder.learn.jdbcTemplete;

import java.util.List;

/**student 的 接口方法  */
public interface StudentDao {

	/**
	 *  创建 student
	 * @param name student name
	 * @param age  student age 
	 * @param id   student id
	 */
	public void create(String name,String age , int id);
	
	/**
	 *  根据 student id 获取 student
	 * @param id  student id
	 */
	public List<Student> getStudent(int id);
	
	
	/**
	 * 根据 id 修改 姓名 和 年龄
	 * 
	 * */
	public void updateById(int id,String name,String age);
}
