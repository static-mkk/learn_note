package cn.kkcoder.learn.jdbcTemplete;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * StudentDao 的 具体的实现方法
 *  
 * */

@Component
public class StudentJdbcTemp implements StudentDao {

	private DataSource dataSource;
	private JdbcTemplate jdbc ; 
	
	/**
	 *   初始化 jdbctemplate
	 * @param d
	 */
	@Autowired
	public StudentJdbcTemp(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbc =  new JdbcTemplate(dataSource);
	}

	public void create(String name, String age, int id) {

		String sql = "insert into blog.student (name,age) values ( ?, ?)";
		jdbc.update(sql,name,age );
		System.out.println("create student sucess");
		
	}


	public void updateById(int id,String name,String age) {

		String sql = "update blog.student (name,age) values (?,?) ";
		jdbc.update(sql,name,age);
		System.out.println("updateById");
		
	}

	public Student getStudent(int id) {
		String name = "mkk";
		String sql =  "select from blog.student name = mkk";
		jdbc.query(sql, new StudentWrrap());
		System.out.println("getStudent success");
		return null;
	}
	
	
	
	
	
}
