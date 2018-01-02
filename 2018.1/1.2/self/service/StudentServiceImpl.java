package cn.kkcoder.learn.aop.self.service;


import cn.kkcoder.learn.aop.self.dao.StudentDaoImp;


public class StudentServiceImpl implements studentService {

	private StudentDaoImp studentDaoImp;
	public void setStudentDaoImp(StudentDaoImp studentDaoImp) {
		this.studentDaoImp = studentDaoImp;
	}
	
	
	public void saveStudent() {
		this.studentDaoImp.saveStudent();
	} 

}
