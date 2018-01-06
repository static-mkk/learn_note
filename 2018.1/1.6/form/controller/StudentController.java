package cn.kkcoder.spring_mvc.form.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.result.RequestResultMatchers;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.kkcoder.spring_mvc.form.Student;

/**
 * 
 * @author static-mkk 
 * @date 6 Jan 2018  4:32:23 PM
 * @myblog  www.kkcoder.cn
 *
 *   学生 表单 控制器
 */
@Controller
public class StudentController {

	@RequestMapping(value="/student" ,method=RequestMethod.GET)
	public ModelAndView student(){
		return new ModelAndView("student","command" , new Student());
	}
	
	
	@RequestMapping(value="/addStudent",method=RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student,Model map,HttpServletRequest req){
		System.out.println(student.getAge() + "name : "+ student.getName() );
		map.addAttribute("age",student.getAge());
		map.addAttribute("name",student.getName());
		return "addstudent";
	}
	
	
}
