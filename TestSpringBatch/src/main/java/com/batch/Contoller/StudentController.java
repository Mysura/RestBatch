package com.batch.Contoller;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batch.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	private List<Student>  getStudents(){
		
		Student mysura = new Student();
		mysura.setMail("mysura@gmail.com");
		mysura.setName("Mysura");
	    Student reddy = new Student();
		mysura.setMail("reddy@gmail.com");
		mysura.setName("Reddy");
		return Arrays.asList();
	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Student> listStudents(){
		
		
		return getStudents();
		
	}
	
	
	
	
	
	
	

}
