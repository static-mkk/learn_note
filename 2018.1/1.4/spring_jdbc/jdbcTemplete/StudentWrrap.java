package cn.kkcoder.learn.jdbcTemplete;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


/**
 *  student 查询数据库之后的包装类
 * @author xuanqi1
 *
 */
@Component
public class StudentWrrap implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int arg1) throws SQLException {
		Student s = new Student();
		s.setAge(rs.getString("id"));
		s.setName(rs.getString("name"));
		
		return s;
	}

}
